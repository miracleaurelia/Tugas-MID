
public class admin extends karyawan {
	protected float bonusAdmin;

	public admin(String kode, String gender, String nama, String jabatan, int gaji, float bonusAdmin) {
		super(kode, gender, nama, jabatan, gaji);
		this.bonusAdmin = bonusAdmin;
	}

	public float getBonusAdmin() {
		return bonusAdmin;
	}

	public void setBonusAdmin(float bonusAdmin) {
		this.bonusAdmin = bonusAdmin;
	}
	
}