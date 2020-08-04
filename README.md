### Spring e aws

###### Copiando arquivos para dentro da ec2

scp -i chave.pem arquivo.jar ec2-user@ec2-52-205-99-190.compute-1.amazonaws.com:~ (na raiz ou posso indicar um diretorio)

###### Comandos aws cli
```
aws configure --profile nome do usuario iam
aws s3 ls (listar os buckets)
aws s3 mb s3://devfabricio (criar um bucket)
aws s3 rb s3://devfabricio (remover um bucket)
aws s3 cp teste.txt s3://fabriciotest/pasta que deseja (enviando um arquivo)
aws s3 cp teste.txt s3://fabriciotest/pasta que deseja  -- delete (o que apagar da minha pasta, apaga que esta no s3)
aws s3 sync . s3://fabriciotest (sincronizar os arquivos para um bucket)
```

Criando uma maquina ec2
```
aws ec2 run-instances --instance-type t2.micro --image-id ami-0c0ec4f9dfef65946
``` 

###### Comandos terraform
``` 
terraform init
terraform plan (adicionar os recursos que estão no arquivo tf)
terraform apply (aplicar as mudanças)
``` 
