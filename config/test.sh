#!/bin/bash

sleep 4 # wait to start vault server
export VAULT_ADDR="http://127.0.0.1:8200"
vault secrets disable secret
vault secrets enable -version=1 -path=secret kv
vault kv put -format=json secret/application @product-service.json