import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrasilTaxService;
import model.services.RentalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");

        System.out.println("Enter rental data");
        System.out.print("car model: ");
        String carModel = sc.nextLine();
        System.out.print("Pickup (dd/MM/yyy hh:mm): ");
        Date start = sdf.parse(sc.nextLine());
        System.out.print("Return (dd/MM/yyy hh:mm): ");
        Date finish = sdf.parse(sc.nextLine());

        CarRental cr = new CarRental(start,finish,new Vehicle(carModel));

        System.out.print("Enter price per hour: ");
        double pph = sc.nextDouble();
        System.out.print("Enter price per day: ");
        double ppd = sc.nextDouble();

        RentalService service = new RentalService(ppd,pph, new BrasilTaxService());
        service.processInvoice(cr);

        System.out.println();

        System.out.println("INVOICE :");
        System.out.println("Basic payment: "+String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: "+String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total payment: "+String.format("%.2f", cr.getInvoice().getTotalPayment()));
        sc.close();
    }
}
