# saga-orchestration
saga-orchestration
Fluxo da Aplicação da Prova Conceito <br/>
<img src="https://github.com/weder96/saga-orchestration/blob/main/doc/saga-orchestration.png" />

# start Kafka (Linux)
STEP 1: GET KAFKA<br/>
Download the latest Kafka release and extract it:<br/><br/>

@Versão na data da  criação deste repositório.<br/>
$ tar -xzf kafka_2.13-2.8.0.tgz<br/>
$ cd kafka_2.13-2.8.0<br/><br/>


STEP 2: START THE KAFKA ENVIRONMENT<br/>
NOTE: Your local environment must have Java 8+ installed.<br/>
Run the following commands in order to start all services in the correct order:<br/><br/>

#Start the ZooKeeper service<br/>
#Note: Soon, ZooKeeper will no longer be required by Apache Kafka.<br/>

$ bin/zookeeper-server-start.sh config/zookeeper.properties<br/>
Open another terminal session and run:<br/><br/>

#Start the Kafka broker service<br/>
$ bin/kafka-server-start.sh config/server.properties<br/>
Once all services have successfully launched, you will have a basic Kafka environment running and ready to use<br/><br/>

# Teste Aplicação via Postman

Assim que todos os serviços estiverem funcionando, envio uma solicitação POST para criar o pedido. Recebo o status do pedido criado.<br/>
01 - Create Order via Post<br/>
<img src="https://github.com/weder96/saga-orchestration/blob/main/doc/create_order.png" />
<br/>
Enviei varios pedidos. Assim,  solicitações foram atendidas. Pois o usuário teria apenas $100 restantes e não podemos atender ao 4ºpedido. Portanto, o serviço de pagamento teria declinado.<br/>

02 - Selecionar todas as Order criada<br/>
<img src="https://github.com/weder96/saga-orchestration/blob/main/doc/order_all.png" />

<br/>
03 - Selecionar todas as Order criada (recolhido dados)<br/>
<img src="https://github.com/weder96/saga-orchestration/blob/main/doc/order_all_2.png" />

<br/>
Resumo:<br/>
Manipular transações e manter a consistência de dados entre todos os microsserviços são geralmente difíceis.<br/> 
Quando vários serviços estão envolvidos, como pagamento, inventário, verificação de fraude, verificação de remessa ... etc., seria muito difícil gerenciar um fluxo de trabalho tão complexo com várias etapas sem um coordenador. <br/>
Ao introduzir um serviço separado para o coordenador, o serviço de pedidos é liberado dessas responsabilidades. <br/>
Também não estamos introduzindo nenhuma dependência cíclica.
