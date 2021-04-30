package com.project.saludLegal.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.saludLegal.models.CuotaModeradora;


/**

 * Repositorio para obtener informacion de las cuotas moderadoras desde la base de datos

 * @author: Manuel Alejandro Verjan Robles

 */

@Repository
public interface CuotaRepository extends CrudRepository <CuotaModeradora, Long>{
	
	/**
	   * Query para obtener cuota moderadora dado un id de tipo de contrato y un id de tipo de cita
	   * @param idTipoCita. id del tipo de cita relacionado a la cuota moderadora
	   * @param idTipoContrato. id del tipo de contrato relacionado a la cuota moderadora
	   * @return Cuota Moderadora encontrada
	*/
	// La tabla Sl_cuotas_moderadoras asociada a la entidad CuotaModeradora, contiene un índice compuesto, en los campos id_tipo_contrato y id_tipo_cita
	@Query("Select c from CuotaModeradora c where c.idTipoContrato.idTipoContrato = ?1 and c.idTipoCita.idTipoCita =?2")
	CuotaModeradora findByIdTipoContratoIdTipoContratoAndIdTipoCitaIdTipoCita(Long idContrato, Long idTipoCita);
	
	/**
	   * JPQL Query para modificar una cuota moderadora
	   * @param idTipoCita. id del tipo de cita relacionado a la cuota moderadora
	   * @param idTipoContrato. id del tipo de contrato relacionado a la cuota moderadora
	   * @Param nuevoValor. Nuevo valor, es decir, coste monetario, que se va a dar a dicha cuota moderadora
	   * @return Cuota Moderadora encontrada
	*/
	// La tabla Sl_cuotas_moderadoras asociada a la entidad CuotaModeradora, contiene un índice compuesto, en los campos id_tipo_contrato y id_tipo_cita
	@Modifying
	@Query("update CuotaModeradora c set c.valorCuotaModeradora = ?3 where c.idTipoContrato.idTipoContrato = ?2 and c.idTipoCita.idTipoCita =?1")
	int setValorCuotaModeradoraforCuotaModeradora(Long idTipoCita, Long idContrato,  Long nuevoValor);
	
	/**
	   * Native Query para agregar log de la modificación de una cuota moderadora
	*/
	@Modifying
	@Query(value="insert into sl_logs_cuotas (valor_nuevo, id_tipo_cita, id_tipo_contrato, id_ejecuta) values (?3, ?1, ?2, ?4)", nativeQuery=true)
	void logCambioCuota(Long idTipoCita, Long idContrato,  Long nuevoValor, Long idOperador);
	
}
