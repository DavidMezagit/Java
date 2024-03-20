import java.util.ArrayList;

public class Estudiante extends Persona implements Calculable {
	private int note_final;
	private double notaCuatri = 0;

	public Estudiante(String nombre, String apellido, int dni, int note_final, double prom_final) {
	    super(nombre, apellido);
	    try {
	        setDni(dni);
	    } catch (DniInvalido e) {
	        e.printStackTrace();
	    }
	    this.note_final = note_final;
	    this.notaCuatri = prom_final;
	}

	public int getNote_final() {
		return note_final;
	}

	public void setNote_final(int note_final) {
		this.note_final = note_final;
	}

	public double getNotaCuatri() {
		return notaCuatri;
	}

	public void setNotaCuatri(double notaCuatri) {
		this.notaCuatri = notaCuatri;
	}

	public String Datos() {
		return "Nombre: " + getNombre() + ", Apellido: "+ getApellido() + ", Nota final:" + note_final + ", promedio final:" + notaCuatri + "";
	}

	@Override
	public double CalcularPromedio(ArrayList<Estudiante> listEst) {
		double notas = 0;
		for (Estudiante e : listEst) {
			notas += e.getNotaCuatri();
		}
		this.notaCuatri = notas / listEst.size();

		return notaCuatri;
	}

}