# Teste de seleção para vaga de Java

Api rest utilizando spring boot com postegresql, jpa hibernate, validation</br>
swagger e cobertura de testes e2e, integration

Tests passed: 41 of 41

No repository usando o metodo findBy sem a necessidade de escrever manualmente a query e realizando todas as buscas.

Mudei alguns valores de entrada que foram propostos

	"weight" -> "peso",
	"zipCodeOrigin" -> "cepOrigem",
	"zipCodeDestination" -> "cepDestino",
	"recipientName" -> "nomeDestinatario",
  	"costFreight" -> "vlTotalFrete",
  	"expectedDeliveryDate" -> "dataPrevistaEntrega",


Seguindo o principio da responsabilidade única, DispatchStoreController cuida da criação e DispatchFindController da busca, são os únicos controladores

No DispatchStoreController tem a busca isolada dos ceps, com try catch, caso não encontre e desconto.

Implementação do desconto com ddd, localidade, peso da encomenda e dia previsto para entregar.

Todos os testes passaram com exceção do shouldFindRecipientName no DispatchFindControllerTest, que por algum motivo</br>
que não consegui resolver, fazia o registr no banco, mas não me retornava ele

Busca por nome, id, peso, data prevista para entregar, cep de origem, cep de destino, frete
 
 
http://localhost:3333/swagger-ui/#/

Em src -> main -> resource -> aplication.properties, necessário colocar os dados do banco para rodar aplicação

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


  
 
