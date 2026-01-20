import java.util.Scanner;

public class tipoDeVeiculo {
/* 
Desenvolva um algoritmo que utilize as seguintes características de um veículo:
- Quantidade de rodas;
- Peso bruto em quilogramas;
- Quantidade de pessoas no veículo.

Com essas informações, o programa mostrará qual é a melhor categoria de habilitação para o veículo informado a partir das condições:
A: Veículos com duas ou três rodas;
B: Veículos com quatro rodas, que acomodam até oito pessoas e seu peso é de até 3500 kg;
C: Veículos com quatro rodas ou mais e com peso entre 3500 e 6000 kg;
D: Veículos com quatro rodas ou mais e que acomodam mais de oito pessoas; 
E: Veículos com quatro rodas ou mais e com mais de 6000 kg.
*/

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int tempQuantidadeRodas;
        int tempPesoBruto;
        int tempQuantidadePessoas;

        System.out.println("Vamos registrar seu veiculo!");
        System.out.print("Digite a quantidade de rodas do seu veiculo (valor minimo de 2): ");
        tempQuantidadeRodas = sc.nextInt();
        System.out.print("Digite o peso do seu veiculo (sem pontos ou virgulas ex: 3500): ");
        tempPesoBruto = sc.nextInt();
        System.out.print("Digite quantas pessoas cabem em seu veiculo (motorista incluso): ");
        tempQuantidadePessoas = sc.nextInt();
        new Veiculo(tempQuantidadeRodas, tempPesoBruto, tempQuantidadePessoas);
        System.out.println();
        sc.close();
    }

    public enum CNH {
        A,
        B,
        C,
        D,
        E
    }

    public static class Veiculo{
        private int quantidadeRodas;
        private int pesoBruto;
        private int quantidadePessoas;
        private CNH tipoCnh;

        public Veiculo(int quantidadeRodas, int pesoBruto, int quantidadePessoas){
            this.quantidadeRodas = quantidadeRodas;
            this.quantidadePessoas = quantidadePessoas;
            this.pesoBruto = pesoBruto;
            calculoTipoCnh();
            System.out.println(toString());
        }


        public int getQuantidadeRodas() {
            return quantidadeRodas;
        }

        public int getPesoBruto() {
            return pesoBruto;
        }

        public int getQuantidadePessoas() {
            return quantidadePessoas;
        }
                
        public CNH getTipoCnh() {
            return tipoCnh;
        }

        private void calculoTipoCnh(){
            if (quantidadeRodas >= 4){
                if (quantidadePessoas > 8) tipoCnh = CNH.D;
                else {
                    if (pesoBruto > 6000) tipoCnh = CNH.E;
                    else if (quantidadePessoas <= 8 && pesoBruto <= 3500) tipoCnh = CNH.B;
                    else tipoCnh = CNH.C;
                }
            } else {
                tipoCnh = CNH.A;
            }   
        }

        @Override
        public String toString() {
            return "Seu tipo de habilitação é: " + tipoCnh;
        }

    }

}
