
public class supervisor extends karyawan {
	protected float bonusSupervisor;

	public supervisor(String kode, String gender, String nama, String jabatan, int gaji, float bonusSupervisor) {
		super(kode, gender, nama, jabatan, gaji);
		this.bonusSupervisor = bonusSupervisor;
	}

	public float getBonusSupervisor() {
		return bonusSupervisor;
	}

	public void setBonusSupervisor(float bonusSupervisor) {
		this.bonusSupervisor = bonusSupervisor;
	}
	
}