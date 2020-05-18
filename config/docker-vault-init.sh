#!/bin/sh

vault login 934f9eae-31ff-a8ef-e1ca-4bea9e07aa09

vault secrets disable secret
vault secrets enable -version=1 -path=secret kv
vault kv put secret/application  @/config/product-service.json
vault kv put secret/application/docker  @/config/product-service.json
