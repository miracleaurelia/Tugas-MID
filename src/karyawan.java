
public class karyawan {
	public String kode;
	public String gender;
	public String nama;
	protected String jabatan;
	private int gaji;
	
	public karyawan(String kode, String gender, String nama, String jabatan, int gaji) {
		super();
		this.kode = kode;
		this.gender = gender;
		this.nama = nama;
		this.jabatan = jabatan;
		this.gaji = gaji;
	}
	
	public String getKode() {
		return kode;
	}
	public String getGender() {
		return gender;
	}
	public String getNama() {
		return nama;
	}
	public String getJabatan() {
		return jabatan;
	}
	public int getGaji() {
		return gaji;
	}
	public void setKode(String kode) {
		this.kode = kode;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
	public void setGaji(int gaji) {
		this.gaji = gaji;
	}
}
