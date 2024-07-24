package com.teste.primeiro_exemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiro_exemplo.Model.Produto;

@Repository
public class ProdutoRepository {
    //#region Atributos
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;
    //#endregion

    //#region Metodos
        /**
         * metodo para retorna uma lista de produtos
            * @return lista de produtos
         */
        public List<Produto> obterTodos(){
            return produtos;
        }

        /**
         * Mtodo que retorna o produto encontrado pelo seu id
         * @param id do produto que sera localizado
         * @return Retorna um produto caso seja encontrado
         */
        public Optional<Produto> obterPorId(Integer id){
            return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
        }

        /**
         * metodo para adicionar produto na lista
         * @param produto adicionado
         * @return retorn o produto que foi adicionado na lista.
         */
        public Produto adicionar(Produto produto){
            ultimoId ++; //incremento id
            produto.setId(ultimoId); // gravo no produto
            produtos.add(produto); // adiciono ele no banco
            return produto;
        }

        /**
         * Metodo para deletar o produto por id
         * @param id do produto a ser deletado
         */
        public void deletar(Integer id){
            produtos.removeIf(produto -> produto.getId() == id);
        }

        public Produto atualizar(Produto produto){
            //encontrar produto
            Optional<Produto> produtoEncontrado = obterPorId(produto.getId()); 
            if(produtoEncontrado.isEmpty()){
                throw new InputMismatchException("Produto não encontrado");
            }
            // remover produto antigo 
            deletar(produto.getId());
            // adicionar novo produto
            //nao posso usar o metodo adicionar pq ele incrementa o id
            produtos.add(produto);

            return produto;
        }

        
    //#endregion
}
