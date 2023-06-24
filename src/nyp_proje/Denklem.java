package nyp_proje;

import java.util.Random;

public class Denklem {
	
public static String generateEquation() {
		
		@SuppressWarnings("unused")
		int sayi1,sayi2,sayi3,sonuc=0,x,y,t,total;
		String denklem="";
		
		Random generator = new Random();
			
			y=generator.nextInt(2);
			y++;
			if(y==1){
				do{
					total=1;
					sayi1=generator.nextInt(999);                              //1. sayi
					sayi1++;
			
					if(sayi1<10){
						total += 1;
					}else if(sayi1<100){
						total += 2;
					}else{
						total += 3;
					}
			
					sayi2=generator.nextInt(999);                               //2. sayi
					sayi2++;
					
					if(sayi2<10){
						total += 1;
					}else if(sayi2<100){
						total += 2;
					}else{
						total += 3;
					}
			
					x=generator.nextInt(4);
					x++;
			
					if(x==1){                                            //islem secimi
						sonuc=sayi1+sayi2;
					}else if(x==2){
						if(sayi1<sayi2){
							total=10;
						}
						sonuc=sayi1-sayi2;
					}else if(x==3){
						if(sayi1%sayi2 == 0){
							sonuc=sayi1/sayi2;
						}else{
							total=10;
						}
				
					}else{
						sonuc=sayi1*sayi2;
					}
			
					if(sonuc<10){
						total += 1;
					}else if(sonuc<100){
						total += 2;
					}else if(sonuc<1000){
						total += 3;
					}else{
						total += 4;
					}
			
					total += 1;
					
					
					
				}while((total!=7) && (total!=8) && (total!=9));
			
					if(x==1){
						denklem=sayi1 + "+" + sayi2 + "=" + sonuc;
					}else if(x==2){
						denklem=sayi1 + "-" + sayi2 + "=" + sonuc;
					}else if(x==3){
						denklem=sayi1 + "/" + sayi2 + "=" + sonuc;
					}else{
						denklem=sayi1 + "*" + sayi2 + "=" + sonuc;
					}
				
			}else{       //2 tane islem var
				
				do{
					total=1;
					sayi1=generator.nextInt(999);
					sayi1++;
			
					if(sayi1<10){
						total += 1;
					}else if(sayi1<100){
						total += 2;
					}else{
						total += 3;
					}
			
					sayi2=generator.nextInt(999);
					sayi2++;
					
					if(sayi2<10){
						total += 1;
					}else if(sayi2<100){
						total += 2;
					}else{
						total += 3;
					}
					
					sayi3=generator.nextInt(999);
					sayi3++;
					
					if(sayi3<10){
						total += 1;
					}else if(sayi3<100){
						total += 2;
					}else{
						total += 3;
					}
					
					
					x=generator.nextInt(16);                  //islem secme kismi
					x++;
			
					if(x==1){                       //a+b+c
						sonuc = sayi1+sayi2+sayi3;
					}else if(x==2){                 //a+b-c
						if( (sayi1+sayi2) < sayi3){
							total=10;
						}else{
							sonuc=sayi1+sayi2-sayi3;
						}
					}else if(x==3){                 //a+b/c
						if((sayi2%sayi3) == 0){
							sonuc = sayi1 + sayi2/sayi3;
						}else{
							total=10;
						}
					}else if(x==4){                 //a+b*c
						sonuc = sayi1 + sayi2*sayi3;
					}else if(x==5){                 //a-b+c
						if( (sayi1+sayi3) < sayi2){
							total=10;
						}else{
							sonuc=sayi1-sayi2+sayi3;
						}
					}else if(x==6){                 //a-b-c
						if( (sayi2+sayi3) < sayi1){
							sonuc=sayi1-sayi2-sayi3;
						}else{
							total=10;
						}
						
					}else if(x==7){                 //a-b/c
						if( (sayi2%sayi3) == 0){
							if(sayi1 > (sayi2/sayi3)){
								sonuc = sayi1 - sayi2/sayi3;
							}else{
								total=10;
							}
						}else{
							total=10;
						}
					}else if(x==8){                 //a-b*c
						if(sayi1 > (sayi2*sayi3) ){
							sonuc = sayi1 - sayi2*sayi3;
						}else{
							total=10;
						}
					}else if(x==9){                 //a/b+c
						if((sayi1%sayi2) == 0){
							sonuc = sayi1/sayi2 + sayi3;
						}else{
							total=10;
						}
					}else if(x==10){                //a/b-c
						if((sayi1%sayi2) == 0){
							if((sayi1/sayi2) > sayi3){
								sonuc = sayi1/sayi2 - sayi3;
							}else{
								total=10;
							}
						}else{
							total=10;
						}
					}else if(x==11){                //a/b/c
						if((sayi1%sayi2) == 0){
							if( ((sayi1/sayi2) % sayi3) == 0){
								sonuc=(sayi1/sayi2)/sayi3;
							}else{
								total=10;
							}
						}else{
							total=10;
						}
					}else if(x==12){                //a/b*c
						if((sayi1%sayi2) == 0){
							sonuc = (sayi1/sayi2)*sayi3;
						}else{
							total=10;
						}
					}else if(x==13){                //a*b+c
						sonuc = sayi1*sayi2 +sayi3;
					}else if(x==14){                //a*b-c
						if( (sayi1*sayi2) > sayi3){
							sonuc = sayi1*sayi2-sayi3;
						}else{
							total=10;
						}
					}else if(x==15){                //a*b/c
						if( (sayi1*sayi2)%sayi3 == 0){
							sonuc = (sayi1*sayi2)/sayi3;
						}else{
							total=10;
						}
					}else if(x==16){                //a*b*c
						sonuc=sayi1*sayi2*sayi3;
					}
					
					if(sonuc<10){
						total += 1;
					}else if(sonuc<100){
						total += 2;
					}else if(sonuc<1000){
						total += 3;
					}else{
						total += 4;
					}
					
					total +=2;
						
				}while((total!=7) && (total!=8) && (total!=9));
				
				if(x==1){
						denklem=sayi1 + "+" + sayi2 + "+" + sayi3 + "=" + sonuc;
				}else if(x==2){
						denklem=sayi1 + "+" + sayi2 + "-" + sayi3 + "=" + sonuc;
				}else if(x==3){
						denklem=sayi1 + "+" + sayi2 + "/" + sayi3 + "=" + sonuc;
				}else if(x==4){
						denklem=sayi1 + "+" + sayi2 + "*" + sayi3 + "=" + sonuc;
				}else if(x==5){
						denklem=sayi1 + "-" + sayi2 + "+" + sayi3 + "=" + sonuc;
				}else if(x==6){
						denklem=sayi1 + "-" + sayi2 + "-" + sayi3 + "=" + sonuc;
				}else if(x==7){
						denklem=sayi1 + "-" + sayi2 + "/" + sayi3 + "=" + sonuc;
				}else if(x==8){
						denklem=sayi1 + "-" + sayi2 + "*" + sayi3 + "=" + sonuc;
				}else if(x==9){
						denklem=sayi1 + "/" + sayi2 + "+" + sayi3 + "=" + sonuc;
				}else if(x==10){
						denklem=sayi1 + "/" + sayi2 + "-" + sayi3 + "=" + sonuc;
				}else if(x==11){
						denklem=sayi1 + "/" + sayi2 + "/" + sayi3 + "=" + sonuc;
				}else if(x==12){
						denklem=sayi1 + "/" + sayi2 + "*" + sayi3 + "=" + sonuc;
				}else if(x==13){
						denklem=sayi1 + "*" + sayi2 + "+" + sayi3 + "=" + sonuc;
				}else if(x==14){
						denklem=sayi1 + "*" + sayi2 + "-" + sayi3 + "=" + sonuc;
				}else if(x==15){
						denklem=sayi1 + "*" + sayi2 + "/" + sayi3 + "=" + sonuc;
				}else if(x==16){
						denklem=sayi1 + "*" + sayi2 + "*" + sayi3 + "=" + sonuc;
				}
			}
			
		
			return denklem;
	}

	public boolean checkEquation(String eq){
		if(!operatorsCheck(eq)){
			return false;
		}
		if(!isEquationTrue(eq))
			return false;
    
		return true;
	}

	private boolean operatorsCheck(String eq) {

		if(!containsEqualsSign(eq))                                                                             
			return false;

		if(isOperator(eq.charAt(0)) || isOperator(eq.charAt(eq.length()-1)) || eq.charAt(eq.length()-1)=='=')   //Basinda veya sonunda operator var mi
			return false;
    
		for(int i=1; i<eq.length(); i++){                                                                       //Art arda operator var mý
			if(isOperator(eq.charAt(i)) && isOperator(eq.charAt(i-1)))
				return false;
		}
		return true;
	}

	private boolean containsEqualsSign(String eq){                                                                //Esittir isareti var mi
		for(int i=0; i<eq.length(); i++){
			if(eq.charAt(i)=='=')
				return true;
		}
		return false;
	}

	private boolean isEquationTrue(String eq){
		String[] parts = eq.split("(?=[=])|(?<=[=])");                                                           //Esittir oncesi ve sonrasini ayirir
		int result = Integer.parseInt(parts[2]);
		eq=parts[0];
		parts = eq.split("(?=[+-])|(?<=[+-])");                                                                  //denklemi + ve -ye gore ayir
		switch (parts.length) {
			case 1 -> {if(result == case1(parts[0]))                                                             //+ veya - yoksa
				return true;
			}
			case 3 -> {if(result == case3(parts))                                                                 //bir tane + veya - varsa
				return true;
			}
			case 5 -> {if(result == case5(parts))                                                                 //iki tane + veya - varsa
				return true;
			}
       	default -> {
       		return false;
       	}
		}
		return false;
	}

	private int case1(String eq){
		String[] parts = eq.split("(?=[*/])|(?<=[*/])");                                                               //Bu sefer de * ve / ye gore ayir

		int result=-1111;
		switch (parts.length) {
			case 3 -> {                                                                                                 //sadece bir tane * veya / varsa
				if(parts[1].charAt(0)=='*'){
					result = Integer.parseInt(parts[0]) * Integer.parseInt(parts[2]);
				}else if(parts[1].charAt(0)=='/'){
					result = Integer.parseInt(parts[0]) / Integer.parseInt(parts[2]);
				}
			}
			case 5 -> {                                                                                                //iki tane * veya / varsa
				if(parts[1].charAt(0)=='*'){
					result = Integer.parseInt(parts[0]) * Integer.parseInt(parts[2]);
				}else if(parts[1].charAt(0)=='/'){
					result = Integer.parseInt(parts[0]) / Integer.parseInt(parts[2]);
				}
				if(parts[3].charAt(0)=='*'){
					result *= Integer.parseInt(parts[4]);
				}else if(parts[3].charAt(0)=='/'){
					result /= Integer.parseInt(parts[4]);
				}
			}
			default -> {
                	return -1111;
			}
		}
		return result;
	}


	private int case3(String[] parts){
		int result=-1111;
    
		if(!isNumeric(parts[0]))                                                                                      // ayrilan ilk kisim numerik degilse sonucu hesaplayip yine ilk kisma yaz
			parts[0] = Integer.toString(case1(parts[0]));
		if(!isNumeric(parts[2]))                                                                                // ayrilan ikinci kisim numerik degilse sonucu hesaplayip yine ikinci kisma yaz
			parts[2] = Integer.toString(case1(parts[2]));
                                                                                                                   //hesapla
		if(parts[1].charAt(0)=='+'){
			result = Integer.parseInt(parts[0])+ Integer.parseInt(parts[2]);
		}else if(parts[1].charAt(0)=='-'){
			result = Integer.parseInt(parts[0]) - Integer.parseInt(parts[2]);
		}
    
		return result;
	}


	private int case5(String[] parts){
		int result=0;
                                                                                                                      //Once ilk islem
		if(parts[1].charAt(0)=='+'){
			result = Integer.parseInt(parts[0])+ Integer.parseInt(parts[2]);
		}else if(parts[1].charAt(0)=='-'){
			result = Integer.parseInt(parts[0]) - Integer.parseInt(parts[2]);
		}
                                                                                                                        //sonra ikinci islem
		if(parts[3].charAt(0)=='+'){
			result += Integer.parseInt(parts[4]);
		}else if(parts[3].charAt(0)=='-'){
			result -= Integer.parseInt(parts[4]);
		}	
    
		return result;
	}

private boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        int i = Integer.parseInt(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}

public boolean isOperator(char c){
    return c == '+' || c == '-' || c == '*' || c == '/';
}

}
