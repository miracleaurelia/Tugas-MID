import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
	ArrayList<karyawan>arrlist=new ArrayList<>();
	Scanner scan=new Scanner(System.in);
	int ctrM=0,ctrS=0,ctrA=0;
	public Main() {
		int choice;
		do {
			System.out.println("PT. Mentol Employee Management");
			System.out.println("Masukkan pilihan:");
			System.out.println("1. Insert data karyawan");
			System.out.println("2. View data karyawan");
			System.out.println("3. Update data karyawan");
			System.out.println("4. Delete data karyawan");
			System.out.println("5. Exit");
			choice=scan.nextInt();scan.nextLine();
			switch (choice) {
			case 1:
				String innama,ingender,inrank;
				do {
					System.out.print("Input nama karyawan [>= 3]: ");
					innama=scan.nextLine();
				} while (innama.length()<3);
				do {
					System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
					ingender=scan.nextLine();
				} while (!ingender.contentEquals("Laki-laki")&&!ingender.contentEquals("Perempuan"));
				do {
					System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
					inrank=scan.nextLine();
				} while (!inrank.contentEquals("Manager")&&!inrank.contentEquals("Supervisor")&&!inrank.contentEquals("Admin"));
				Random rand=new Random();
				int codeno=rand.nextInt(9000)+1000;
				char a=(char)(rand.nextInt(26)+'A');
				char b=(char)(rand.nextInt(26)+'A');
				String code=a+""+b+"-"+codeno;
				System.out.println("Berhasil menambahkan karyawan dengan id "+code);
				if (inrank.contentEquals("Manager")) {
					ctrM++;
					if ((ctrM-1)%3==0 && ctrM!=1) {
						int flag=ctrM-1;
						System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
						for (int j=0;j<arrlist.size();j++) {
							if (arrlist.get(j) instanceof manager) {
								manager man=(manager) arrlist.get(j);
								int salary=man.getGaji();
								salary+=(salary*10/100);
								arrlist.get(j).setGaji(salary);
								if (flag==1) {
									System.out.println(man.getKode());
								}
								else {
									System.out.print(man.getKode()+", ");
								}
								flag--;
							}
						}
					}
					arrlist.add(new manager(code,ingender,innama,inrank,8000000,10));
				}
				else if (inrank.contentEquals("Supervisor")) {
					ctrS++;
					if ((ctrS-1)%3==0 && ctrS!=1) {
						int flag=ctrS-1;
						System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");
						for (int j=0;j<arrlist.size();j++) {
							if (arrlist.get(j) instanceof supervisor) {
								supervisor sup=(supervisor) arrlist.get(j);
								int salary=sup.getGaji();
								salary+=(salary*75/1000);
								arrlist.get(j).setGaji(salary);
								if (flag==1) {
									System.out.println(sup.getKode());
								}
								else {
									System.out.print(sup.getKode()+", ");
								}
								flag--;
							}
						}
					}
					arrlist.add(new supervisor(code,ingender,innama,inrank,6000000,7.5f));
				}
				else if (inrank.contentEquals("Admin")) {
					ctrA++;
					if ((ctrA-1)%3==0 && ctrA!=1) {
						int flag=ctrA-1;
						System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
						for (int j=0;j<arrlist.size();j++) {
							if (arrlist.get(j) instanceof admin) {
								admin adm=(admin) arrlist.get(j);
								int salary=adm.getGaji();
								salary+=(salary*5/100);
								arrlist.get(j).setGaji(salary);
								if (flag==1) {
									System.out.println(adm.getKode());
								}
								else {
									System.out.print(adm.getKode()+", ");
								}
								flag--;
							}
						}
					}
					arrlist.add(new admin(code,ingender,innama,inrank,4000000,5));
				}
				System.out.println("ENTER to return");
				scan.nextLine();
				break;
			case 2:
				if (arrlist.size()==0) {
					System.out.println("Data tidak terdeteksi, mohon input data terlebih dahulu");
					System.out.println("ENTER to return");
					scan.nextLine();
				}
				else {
					Collections.sort(arrlist, new Comparator<karyawan>() {
						public int compare(karyawan k1, karyawan k2) {
							String s1=k1.getNama();
							String s2=k2.getNama();
							return s1.compareTo(s2);
						}
					});
					System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
					System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|");
					System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
					for(int i=0;i<arrlist.size();i++) {
						System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13d|\n",i+1,arrlist.get(i).getKode(),arrlist.get(i).getNama(),arrlist.get(i).getGender(),arrlist.get(i).getJabatan(),arrlist.get(i).getGaji());
					}
					System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
					System.out.println("ENTER to return");
					scan.nextLine();
				}
				break;
			case 3:
				if (arrlist.size()==0) {
					System.out.println("Data tidak terdeteksi, mohon input data terlebih dahulu");
					System.out.println("ENTER to return");
					scan.nextLine();
				}
				else {
					int update;
					System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
					System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|");
					System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
					for(int i=0;i<arrlist.size();i++) {
						System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13d|\n",i+1,arrlist.get(i).getKode(),arrlist.get(i).getNama(),arrlist.get(i).getGender(),arrlist.get(i).getJabatan(),arrlist.get(i).getGaji());
					}
					System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
					System.out.print("Pilih angka dari list data yang ingin di update: ");
					update=scan.nextInt();scan.nextLine();
					if (update>arrlist.size() || update<=0) {
						System.out.println("Data tidak ditemukan, mohon input angka yang ada dalam tabel");
						System.out.println("ENTER to return");
						scan.nextLine();
					}
					else {
						String innama1,ingender1,inrank1;
						do {
							System.out.print("Input nama karyawan [>= 3]: ");
							innama1=scan.nextLine();
						} while (innama1.length()<3);
						do {
							System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
							ingender1=scan.nextLine();
						} while (!ingender1.contentEquals("Laki-laki")&&!ingender1.contentEquals("Perempuan"));
						do {
							System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
							inrank1=scan.nextLine();
						} while (!inrank1.contentEquals("Manager")&&!inrank1.contentEquals("Supervisor")&&!inrank1.contentEquals("Admin"));
						Random rand1=new Random();
						int codeno1=rand1.nextInt(9000)+1000;
						char a1=(char)(rand1.nextInt(26)+'A');
						char b1=(char)(rand1.nextInt(26)+'A');
						String code1=a1+""+b1+"-"+codeno1;
						System.out.println("Berhasil mengupdate karyawan dengan id "+arrlist.get(update-1).kode);
						if (inrank1.contentEquals("Manager")) {
							ctrM++;
							if ((ctrM-1)%3==0 && ctrM!=1) {
								int flag=ctrM-1;
								System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
								for (int j=0;j<arrlist.size();j++) {
									if (arrlist.get(j) instanceof manager) {
										manager man=(manager) arrlist.get(j);
										int salary=man.getGaji();
										salary+=(salary*10/100);
										arrlist.get(j).setGaji(salary);
										if (flag==1) {
											System.out.println(man.getKode());
										}
										else {
											System.out.print(man.getKode()+", ");
										}
										flag--;
									}
								}
							}
							arrlist.set(update-1,new manager(code1,ingender1,innama1,inrank1,8000000,10));
						}
						else if (inrank1.contentEquals("Supervisor")) {
							ctrS++;
							if ((ctrS-1)%3==0 && ctrS!=1) {
								int flag=ctrS-1;
								System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");
								for (int j=0;j<arrlist.size();j++) {
									if (arrlist.get(j) instanceof supervisor) {
										supervisor sup=(supervisor) arrlist.get(j);
										int salary=sup.getGaji();
										salary+=(salary*75/1000);
										arrlist.get(j).setGaji(salary);
										if (flag==1) {
											System.out.println(sup.getKode());
										}
										else {
											System.out.print(sup.getKode()+", ");
										}
										flag--;
									}
								}
							}
							arrlist.set(update-1,new supervisor(code1,ingender1,innama1,inrank1,6000000,7.5f));
						}
						else if (inrank1.contentEquals("Admin")) {
							ctrA++;
							if ((ctrA-1)%3==0 && ctrA!=1) {
								int flag=ctrA-1;
								System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
								for (int j=0;j<arrlist.size();j++) {
									if (arrlist.get(j) instanceof admin) {
										admin adm=(admin) arrlist.get(j);
										int salary=adm.getGaji();
										salary+=(salary*5/100);
										arrlist.get(j).setGaji(salary);
										if (flag==1) {
											System.out.println(adm.getKode());
										}
										else {
											System.out.print(adm.getKode()+", ");
										}
										flag--;
									}
								}
							}
							arrlist.set(update-1,new admin(code1,ingender1,innama1,inrank1,4000000,5));
						}
						System.out.println("ENTER to return");
						scan.nextLine();
					}
				}
				break;
			case 4:
				if (arrlist.size()==0) {
					System.out.println("Data tidak terdeteksi, mohon input data terlebih dahulu");
					System.out.println("ENTER to return");
					scan.nextLine();
				}
				else {
					int delete;
					System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
					System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|");
					System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
					for(int i=0;i<arrlist.size();i++) {
						System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13d|\n",i+1,arrlist.get(i).getKode(),arrlist.get(i).getNama(),arrlist.get(i).getGender(),arrlist.get(i).getJabatan(),arrlist.get(i).getGaji());
					}
					System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
					System.out.print("Pilih angka dari list data yang ingin di update: ");
					delete=scan.nextInt();scan.nextLine();
					if (delete>arrlist.size() || delete<=0) {
						System.out.println("Data tidak ditemukan, mohon input angka yang ada dalam tabel");
						System.out.println("ENTER to return");
						scan.nextLine();
					}
					else {
						arrlist.remove(delete-1);
						System.out.println("Berhasil menghapus karyawan dengan id "+arrlist.get(delete-1).kode);
						System.out.println("ENTER to return");
						scan.nextLine();
					}
				}
				break;
			case 5:
				System.out.println("Program terminated");
				break;
			}
		} while (choice!=5);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
}