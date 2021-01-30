
public class manager extends karyawan {
	protected float bonusManager;

	public manager(String kode, String gender, String nama, String jabatan, int gaji, float bonusManager) {
		super(kode, gender, nama, jabatan, gaji);
		this.bonusManager = bonusManager;
	}

	public float getBonusManager() {
		return bonusManager;
	}

	public void setBonusManager(float bonusManager) {
		this.bonusManager = bonusManager;
	}
	
}