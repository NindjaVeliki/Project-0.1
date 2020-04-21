FROM postgres
ENV POSTGRES_USER opsdb
ENV POSTGRES_PASSWORD opsdb
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432