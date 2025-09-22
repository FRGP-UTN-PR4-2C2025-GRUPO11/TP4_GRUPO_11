package entidad;

public class TipoSeguro {
	
	private int id;
	private String descripcion;

	public TipoSeguro() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoSeguro [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
