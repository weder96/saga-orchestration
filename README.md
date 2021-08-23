# saga-orchestration
saga-orchestration
Fluxo da Aplicação da Prova Conceito
<img src="https://github.com/weder96/saga-orchestration/blob/main/doc/saga-orchestration.png" />

# start Kafka (Linux)
STEP 1: GET KAFKA
Download the latest Kafka release and extract it:

@Versão na data da  criação deste repositório.
$ tar -xzf kafka_2.13-2.8.0.tgz
$ cd kafka_2.13-2.8.0


STEP 2: START THE KAFKA ENVIRONMENT
NOTE: Your local environment must have Java 8+ installed.
Run the following commands in order to start all services in the correct order:

#Start the ZooKeeper service
#Note: Soon, ZooKeeper will no longer be required by Apache Kafka.

$ bin/zookeeper-server-start.sh config/zookeeper.properties
Open another terminal session and run:

#Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties
Once all services have successfully launched, you will have a basic Kafka environment running and ready to use

# Teste Aplicação via Postman

Assim que todos os serviços estiverem funcionando, envio uma solicitação POST para criar o pedido. Recebo o status do pedido criado.
01 - Create Order via Post
<img src="https://github.com/weder96/saga-orchestration/blob/main/doc/create_order.png" />

Enviei varios pedidos. Assim,  solicitações foram atendidas. Pois o usuário teria apenas $100 restantes e não podemos atender ao 4ºpedido. Portanto, o serviço de pagamento teria declinado.

02 - Selecionar todas as Order criada
<img src="https://github.com/weder96/saga-orchestration/blob/main/doc/order_all.png" />

03 - Selecionar todas as Order criada (recolhido dados)
<img src="https://github.com/weder96/saga-orchestration/blob/main/doc/order_all_2.png" />


Resumo:
Manipular transações e manter a consistência de dados entre todos os microsserviços são geralmente difíceis. Quando vários serviços estão envolvidos, como pagamento, inventário, verificação de fraude, verificação de remessa ... etc., seria muito difícil gerenciar um fluxo de trabalho tão complexo com várias etapas sem um coordenador. Ao introduzir um serviço separado para o coordenador, o serviço de pedidos é liberado dessas responsabilidades. Também não estamos introduzindo nenhuma dependência cíclica.
