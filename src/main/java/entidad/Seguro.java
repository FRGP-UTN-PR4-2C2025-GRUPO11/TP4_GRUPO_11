package entidad;

public class Seguro
{
	private int idSeguro;
	private String descripcion;
	private int idTipo;
	private float costoContrato;
	private float costoAsegurado;
	
	
	// Propiedad no incluida en la base de datos. Sirve para mostrar un campo de la tabla tiposeguro.
	private String idTipodescripcion;

	public Seguro(){}
	
	public int getIdSeguro() {
		return idSeguro;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setId(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public float getCostoContrato() {
		return costoContrato;
	}
	public void setCostoContrato(float costoContrato) {
		this.costoContrato = costoContrato;
	}
	public float getCostoAsegurado() {
		return costoAsegurado;
	}
	public void setCostoAsegurado(float costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}
	
	// Métodos para el atributo idTipodescripcion
	
	public String getIdTipodescripcion() {
		return idTipodescripcion;
	}

	public void setIdTipodescripcion(String idTipodescripcion) {
		this.idTipodescripcion = idTipodescripcion;
	}

	

	@Override
	public String toString() {
		return "Seguro [idSeguro=" + idSeguro + ", descripcion=" + descripcion + ", idTipo=" + idTipo
				+ ", costoContrato=" + costoContrato + ", costoAsegurado=" + costoAsegurado + "]";
	}
	
	
}
