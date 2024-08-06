#!/usr/bin/env bash

# ----------部署后端
IMAGE_NAME="ytwl_app_img"

# 检查镜像是否存在
if sudo docker image inspect "$IMAGE_NAME" >/dev/null 2>&1; then
    echo "镜像 $IMAGE_NAME 已存在."
else
    echo "镜像 $IMAGE_NAME 不存在，正在创建..."
    sudo docker build -t "$IMAGE_NAME" .
fi

CONTAINER_NAME="ytwl_app_cn"
isExists=$(sudo  docker ps -aqf "name=$CONTAINER_NAME")
if [ -n "$isExists" ];then
    echo "容器 $IMAGE_NAME 已存在."
    sudo docker stop $CONTAINER_NAME
    echo "docker stop $CONTAINER_NAME"
    echo "容器 $IMAGE_NAME 已停止"
else
  # 容器不存在就创建
  sudo  mkdir resources
  sudo docker run  -itd  --name $CONTAINER_NAME -p 8090:8090 -v $PWD/resources:/app/resources $IMAGE_NAME
  echo "容器 $IMAGE_NAME 已创建"
fi

isExists=$(sudo  docker ps -aqf "name=$CONTAINER_NAME")
if [ -n "$isExists" ];then
    # 容器存在则替换掉  ytwl_admin.jar
    sudo docker cp ytwl_admin.jar $CONTAINER_NAME:/app/
    sudo docker restart $CONTAINER_NAME
    echo "容器已更新：$CONTAINER_NAME"
fi

