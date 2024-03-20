public abstract class Persona {
	protected String nombre;
	protected String apellido;
	private int dni;

	public Persona() {

	}
	public Persona(String nombre, String apellido) {
	    this.nombre = nombre;
	    this.apellido = apellido;
	}

	public Persona(String nombre, String apellido, int dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}

	public void setDni(int dni) throws DniInvalido {
        if (String.valueOf(dni).length() > 8) {
            throw new DniInvalido("Error: El DNI " + dni + " tiene más de 8 dígitos. ENTER PARA VOLVER A INTENTAR");
        }
        this.dni = dni;
    }

}