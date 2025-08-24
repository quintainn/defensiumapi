# DEFENSIUM v1.0.0.0

**Data de Entrega:** 25/08/2025  
**Projeto:** DEFENSIUMAPI  
**Versão:** [v1.0.0.0](https://github.com/quintainn/defensiumapi/issues?q=state%3Aopen%20label%3A%22Version%20v1.0.0.0%22) 

---

## Resumo
Este release traz a primeira versão dos serviços de cadastro de usuários e tratamento centralizado de erros da API Defensium.  
O objetivo é garantir consistência na criação de novos usuários e respostas padronizadas em caso de falhas.

---

## Novas Funcionalidades

- **Cadastro de Usuário [# DEFENSIUM20250823111844API](https://github.com/quintainn/defensiumapi/issues/2)**  
  - Implementado *endpoint* `POST /defensium/usuario`.  
  - Persistência em `TB_USUARIO` com criptografia de senha (**BCRYPT**).  
  - Atribuição automática do perfil padrão **USER**.  
  - Retorno JSON padronizado com informações de cadastro.  

- **Tratamento Global de Erros (#4)**  
  - Implementado `@ExceptionHandler` para capturar e formatar erros da aplicação.  
  - Respostas padronizadas no formato:  
    ```json
    {
      "mensagem": "<MENSAGEM>",
      "dataHoraRequisicao": "<DATA_HORA>"
    }
    ```
  - Tratamento especial para:  
    - Registro duplicado  
    - Campos obrigatórios nulos ou vazios  

---

## Correções

- Criação de objetos distintos para cada fluxo de dados [DEFENSIUM20250823182834API](https://github.com/quintainn/defensiumapi/issues/4).  
- Correção de defeito de referência cíclica [DEFENSIUM20250823111844API](https://github.com/quintainn/defensiumapi/issues/2).  

---

## Massa de Dados

```sql
curl -X POST http://localhost:8081/defensium/usuario \
     -H "Content-Type: application/json" \
     -d '{
           "nome": "Hyaxiurz Munfuo Pifoystili",
           "usuario": "hyaxiurz.pifoystili@quintain.com.br",
           "senha": "senha-forte",
         }'
```
