#include "DHT.h"
#include "LiquidCrystal.h"
LiquidCrystal lcd(12,11,10,5,4,3,2);
#define DHTPIN 7    
#define DHTTYPE DHT11  
DHT dht(DHTPIN, DHTTYPE);
const int a=A4;
const int b=A3;
 int x ;
void setup() {
  dht.begin();
  lcd.begin(16,2);
  lcd.print("hi");
}
void loop() {
  int mq135 = analogRead(a);
  int mq2 = analogRead(b);
  delay(2000);
  float h = dht.readHumidity();
  float t = dht.readTemperature();
  lcd.setCursor(0,1);
  if (isnan(h) || isnan(t)) {
    lcd.print("T error"); 
    delay(1000);
    lcd.clear();
    return;
  }
  if(mq135>40 && mq135<600 ){
    if(mq2>40 && mq2<400){
      if(h>30 && h<85){
        if(t>20 && t<38 && x==0){
          lcd.clear();
          lcd.print("SAFE DONT WORRY");
          delay(2000);
          
          x=1;
        }
        else if(t<20 && t>38){
          lcd.clear();
          lcd.print("UNSAFE TEMP");
          delay(2000);
          lcd.clear();
          x=0;
        }
      }
      else{
        lcd.clear();
        lcd.print("UNSAFE HUMPDITY");
        delay(2000);
        lcd.clear();
         x=0;
      }
    }
    else{
      lcd.clear();
       
      lcd.print("UNSAFE POLLUTANT");
      
      delay(2000);
      lcd.clear();
      x=0;
    }
  }
  else{
    lcd.clear();
    
    lcd.print("UNSAFE POLLUTANT");
    
    delay(2000);
    lcd.clear();
  }
}
