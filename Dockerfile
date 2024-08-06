# 使用一个基础的 Java 运行时镜像作为基础
FROM ersandoru/openfire

RUN echo "Asia/Shanghai" > /etc/timezone
# 设置工作目录
WORKDIR /app
# 复制当前目录下的 JAR 文件到镜像中的 /app 目录
COPY ytwl_admin.jar /app/ytwl_admin.jar

EXPOSE 8090

# 指定容器启动时运行的命令
CMD ["java", "-jar", "/app/ytwl_admin.jar"]