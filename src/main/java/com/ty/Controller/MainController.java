package com.ty.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.dao.BranchDao;
import com.ty.dao.HospitalDao;
import com.ty.dao.PersonDao;
import com.ty.dto.Address;
import com.ty.dto.Branches;
import com.ty.dto.Encounter;
import com.ty.dto.Hospital;
import com.ty.dto.Medorder;
import com.ty.dto.Person;
import com.ty.dto.Tablets;

public class MainController {
	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		HospitalDao dao = new HospitalDao();
		Person person = new Person();
		BranchDao branchDao = new BranchDao();
		PersonDao personDao = new PersonDao();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1--->Hospital");
		System.out.println("Enter 2--->Person");

		switch (sc.nextInt()) {

		case 1:

			System.out.println("Enter the Hospital Name");
			hospital.setName(sc.next());

			boolean hos = true;

			List<Branches> listb = new ArrayList<Branches>();
			while (hos) {

				System.out.println("Enter 1---->Create branch");
				System.out.println("Enter 2---->dont");
				switch (sc.nextInt()) {
				case 1:

					Branches branches = new Branches();
					Address address = new Address();

					System.out.println("Enter the branch name");
					branches.setName(sc.next());
					System.out.println("Enter the phone");
					branches.setPhone(sc.nextLong());

					System.out.println("Enter the  branch location");
					address.setLocation(sc.next());
					branches.setAddress(address);
					address.setBranches(branches);
					listb.add(branches);
					break;

				default:
					hos = false;
					break;

				}

			}
			hospital.setBranches(listb);
			dao.insertHospital(hospital);
			System.out.println("Data Saved");
			break;

		case 2:
			System.out.println("Enter the person name");
			person.setName(sc.next());
			System.out.println("Enter the person phone");
			person.setPhone(sc.nextLong());
			boolean per = true;
			List<Encounter> liste = new ArrayList<Encounter>();
			List<Medorder> listm = new ArrayList<Medorder>();
			List<Tablets> listT = new ArrayList<Tablets>();
			while (per) {
				System.out.println("Enter 1----> Encounter");
				System.out.println("Enter 2----> No");
				switch (sc.nextInt()) {

				case 1:
					Encounter encounter = new Encounter();

					System.out.println("Enter the encounter reason");
					encounter.setReason(sc.next());
					encounter.setBranches(branchDao.fetchBatch());

					boolean ord = true;
					while (ord) {
						System.out.println("Enter 1---->Create Meorder");
						System.out.println("Enter 2---->No");
						switch (sc.nextInt()) {

						case 1:

							Medorder medorder = new Medorder();
							System.out.println("Enter the descrption");
							medorder.setPescr(sc.next());

							boolean tab = true;
							while (tab) {
								System.out.println("Enter 1---> Add Tablet");
								System.out.println("Enter 2---> No");
								switch (sc.nextInt()) {
								case 1:
									Tablets tablets = new Tablets();
									System.out.println("Enter the name");
									tablets.setName(sc.next());
									System.out.println("Enter the price");
									tablets.setPrice(sc.nextLong());
									listT.add(tablets);
									break;

								default:
									tab = false;
									break;

								}
							}
							medorder.setTablets(listT);
							listm.add(medorder);
							break;

						default:
							ord = false;
							break;
						}
					}
					encounter.setMedorder(listm);
					liste.add(encounter);
					break;

				default:
					per = false;
					break;

				}

			}
			person.setEncounter(liste);
			personDao.insertPerson(person);
			System.out.println("Data Saved");
			break;

		}
	}
}
