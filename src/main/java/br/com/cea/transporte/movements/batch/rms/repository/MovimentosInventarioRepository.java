package br.com.cea.transporte.movements.batch.rms.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import br.com.cea.transporte.movements.batch.rms.model.MovimentosInventario;

@Repository
public interface MovimentosInventarioRepository extends JpaRepository<MovimentosInventario, Long> {

	@Procedure(name = "validarMovimentos", procedureName = "SP_INSERT_VALIDATION_INVENTORY_MOVEMENTS")
	void validarMovimentos(String item, String tipo,Date fecha, Integer quantidade, Integer codigo, String status);

}
