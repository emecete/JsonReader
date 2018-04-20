
public class RescueMedicinePresentations implements Element {
	
	private String medicineRef;
	private String activeIngRef;
	private String inhalerRef;
	private String dose;
	
	public RescueMedicinePresentations(String medicineRef, String activeIngRef,  
			String inhalerRef, String dose) {
		this.medicineRef = medicineRef;
		this.activeIngRef = activeIngRef;
		this.inhalerRef = inhalerRef;
		this.dose = dose;
	}
	
	public String toString() {
		return "RescueMedicinePresentation: \n" + "medicineRef -> " + medicineRef +
				"\nactiveIngRef -> " + activeIngRef + "\ninhalerRef -> " + inhalerRef +
				"\ndose -> " + dose;
	}
	
}
