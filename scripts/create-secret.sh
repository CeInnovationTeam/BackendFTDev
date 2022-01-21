#!/bin/bash
echo "Informe o seu user ocid:(ex. ocid1.user.oc1.._______dincoha)"
read clouduserocid
echo "Realizando login no Oracle Container Registry..."
docker login $(oci iam region-subscription list | grep -oP '(?<="region-key": ")[^"]*' | tr [:upper:] [:lower:]).ocir.io -u $(oci os ns get | grep -oP '(?<="data": ")[^"]*')/$(oci iam user get --user-id ${clouduserocid} | grep -oP '(?<="name": ")[^"]*')
echo "Criando secret..."
kubectl create secret generic ocir --from-file=.dockerconfigjson=$HOME/.docker/config.json --type=kubernetes.io/dockerconfigjson
echo "Final de fluxo..."
