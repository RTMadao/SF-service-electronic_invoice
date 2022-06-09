FROM openjdk:11-jre-slim

COPY build/libs/electronicInvoice-1.0.0-SNAPSHOT.jar home/spring/salcedo_fawcett/electronicInvoice_service.jar
EXPOSE 3009

# Add docker-compose-wait tool -------------------
ENV WAIT_VERSION 2.7.2
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /wait
RUN chmod +x /wait
RUN mkdir -p /home/spring/salcedo_fawcett/generated_resource/invoice
RUN mkdir -p /home/spring/salcedo_fawcett/generated_resource/creditNote
RUN mkdir -p /home/spring/salcedo_fawcett/generated_resource/debitNote
RUN mkdir -p /home/spring/salcedo_fawcett/generated_resource/pdf

CMD /wait && java -jar /home/spring/salcedo_fawcett/electronicInvoice_service.jar