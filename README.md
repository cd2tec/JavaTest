# Teste de seleção para vaga de Java

Api rest utilizando spring boot com postegresql, jpa hibernate, validation</br>
swagger e cobertura de testes e2e, integration

No repository usando o metodo findBy sem a necessidade de escrever manualmente a query e realizando todas as buscas.

Mudei alguns valores de entrada que foram propostos

	"weight" -> "peso",
	"zipCodeOrigin" -> "cepOrigem",
	"zipCodeDestination" -> "cepDestino",
	"recipientName" -> "nomeDestinatario",
  	"costFreight" -> "vlTotalFrete",
  	"expectedDeliveryDate" -> "dataPrevistaEntrega",


Seguindo o principio da responsabilidade única, DispatchStoreController cuida da criação e DispatchFindController da busca, são os únicos controladores

No DispatchStoreController tem a busca isolda dos ceps, com try catch, caso não encontre e desconto.

Implementação do desconto com ddd, localidade, peso da encomenda e dia previsto para entregar.

Todos os testes passaram com exceção do shouldFindRecipientName no DispatchFindControllerTest, que por algum motivo</br>
que não consegui resolver, fazia o registr no banco, mas não me retornava ele
  
http://localhost:3333/swagger-ui/#/

  ```diff

+ POST /api/v1/dispatch/store
@@ GET /api/v1/dispatch/find_by_id @@
@@ GET /api/v1/dispatch/find_by_recipient_name @@
@@ GET /api/v1/dispatch/zip_code_origin @@
@@ GET /api/v1/dispatch/zip_code_destination @@
@@ GET /api/v1/dispatch/total_freight @@
@@ GET /api/v1/dispatch/find_by_weight @@
@@ GET  /api/v1/dispatch/expected_delivery_date @@
 
...


Em src -> main -> resource -> aplication.properties, necessário colocar os dados do banco para rodar aplicação
 
 
