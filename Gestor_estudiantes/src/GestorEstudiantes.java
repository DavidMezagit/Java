import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GestorEstudiantes {
	private List<Estudiante> listaEstudiantes;

	public GestorEstudiantes() {
		super();
		this.listaEstudiantes = new ArrayList<Estudiante>();
	}

	public void AgregarEstudiante(Estudiante agregar) {
		listaEstudiantes.add(agregar);

	}

	public void BuscarEstudiante(int num) {
		for (Estudiante e : listaEstudiantes) {
			if (e.getDni() == num) {
				System.out.println("Datos del estudiante " + e.Datos());
			}
		}
	}

	public void OrdenarLista() {
		Collections.sort(listaEstudiantes, new Comparator<Estudiante>() {
			public int compare(Estudiante e1, Estudiante e2) {

				return Double.compare(e2.getNotaCuatri(), e1.getNotaCuatri());
			}
		});

	}

	public double CalcularPromedio() {
		double notas = 0;
		double notaCuatri = 0;
		for (Estudiante e : listaEstudiantes) {
			notas += e.getNotaCuatri();
		}
		notaCuatri = notas / listaEstudiantes.size();

		return notaCuatri;
	}

	public void MostrarEstudiantes() {

		for (Estudiante e : listaEstudiantes) {
			System.out.println(e.Datos());
		}

	}

}