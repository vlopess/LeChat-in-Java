#!/bin/bash

# Diretório onde estão os arquivos Java


# Compilação de todos os arquivos Java no diretório
javac utils/*.java
javac server/*.java
javac Client/*.java

# Verifica se houve erros na compilação
if [ $? -eq 0 ]; then
    echo "Compilação concluída com sucesso."
else
    echo "Ocorreram erros durante a compilação."
fi

