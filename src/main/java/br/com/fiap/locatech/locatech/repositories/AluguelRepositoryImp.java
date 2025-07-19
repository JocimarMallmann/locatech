package br.com.fiap.locatech.locatech.repositories;

import br.com.fiap.locatech.locatech.entities.Aluguel;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AluguelRepositoryImp implements AluguelRepository {

    private final JdbcClient jdbcClient;

    public AluguelRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Aluguel> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT a.id, a.pessoa_id, a.veiculo_id, a.data_inicio, a.data_fim, a.valor_total, " +
                        "p.nome AS pessoa_nome, p.cpf AS pessoa_cpf, " +
                        "v.modelo AS veiculo_modelo, v.placa AS veiculo_placa " +
                        "FROM alugueis a " +
                        "INNER JOIN pessoas p ON a.pessoa_id = p.id " +
                        "INNER JOIN veiculos v ON a.veiculo_id = v.id " +
                        "WHERE a.id = :id")
                .param("id", id)
                .query(Aluguel.class)
                .optional();
    }

    @Override
    public List<Aluguel> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT a.id, a.pessoa_id, a.veiculo_id, a.data_inicio, a.data_fim, a.valor_total, " +
                        "p.nome AS pessoa_nome, p.cpf AS pessoa_cpf, " +
                        "v.modelo AS veiculo_modelo, v.placa AS veiculo_placa " +
                        "FROM alugueis a " +
                        "INNER JOIN pessoas p ON a.pessoa_id = p.id " +
                        "INNER JOIN veiculos v ON a.veiculo_id = v.id " +
                        "LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Aluguel.class)
                .list();
    }

    @Override
    public Integer save(Aluguel aluguel) {
        return this.jdbcClient
                .sql("INSERT INTO alugueis (pessoa_id, veiculo_id, data_inicio, data_fim, valor_total) " +
                        "VALUES (:pessoaId, :veiculoId, :dataInicio, :dataFim, :valorTotal)")
                .param("pessoaId", aluguel.getPessoaId())
                .param("veiculoId", aluguel.getVeiculoId())
                .param("dataInicio", aluguel.getDataInicio())
                .param("dataFim", aluguel.getDataFim())
                .param("valorTotal", aluguel.getValorTotal())
                .update();
    }

    @Override
    public Integer update(Aluguel aluguel, Long id) {
        return this.jdbcClient
                .sql("UPDATE alugueis SET pessoa_id = :pessoaId, veiculo_id = :veiculoId, data_inicio = :dataInicio, " +
                        "data_fim = :dataFim, valor_total = :valorTotal WHERE id = :id")
                .param("id", id)
                .param("pessoaId", aluguel.getPessoaId())
                .param("veiculoId", aluguel.getVeiculoId())
                .param("dataInicio", aluguel.getDataInicio())
                .param("dataFim", aluguel.getDataFim())
                .param("valorTotal", aluguel.getValorTotal())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM alugueis WHERE id = :id")
                .param("id", id)
                .update();
    }
}




