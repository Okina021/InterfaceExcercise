package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PayPalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre os dados do contrato: ");
        int number = scanner.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(scanner.next(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Valor do contrato: ");
        double totalValue = scanner.nextDouble();
        Contract contract = new Contract(number,date,totalValue);
        System.out.print("Entre com o numero de parcelas: ");
        int intallments = scanner.nextInt();

        ContractService contractService = new ContractService(new PayPalService());
        contractService.processContract(contract,intallments);
        System.out.println("Parcelas:");
        for (Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }
    }
}
