#include <DHT.h>
#include <DHT_U.h>
#include <ESP8266WiFi.h>
#include <FirebaseArduino.h>
#define WIFI_SSID "wifi"
#define WIFI_PASSWORD "password"
#define FIREBASE_HOST "cloudthing-e2328.firebaseio.com"
#define FIREBASE_AUTH "key"
#define DHTPIN            2         
#define DHTTYPE           DHT11  
DHT_Unified dht(DHTPIN, DHTTYPE);
void setup() {
 pinMode(5,INPUT);
 pinMode(2,INPUT);
 Serial.begin(9600);
 dht.begin();
 sensor_t sensor;
 dht.temperature().getSensor(&sensor);
 dht.humidity().getSensor(&sensor);
 WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
 Serial.print("connecting");
 while (WiFi.status() != WL_CONNECTED) {
   Serial.print(".");
   delay(500);
 }
 Serial.println();
 Serial.print("connected: ");
 Serial.println(WiFi.localIP());
 Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
}
void loop() {
  int a,b;
  int t,h;
  sensors_event_t event;  
  dht.temperature().getEvent(&event);
  t=event.temperature; 
  dht.humidity().getEvent(&event);
  h=event.relative_humidity;
  a=analogRead(A0);
  Serial.println("\nmq-2");
  Serial.println(a);
  Firebase.setInt("Mq2",a);
  delay(1000);
  Serial.println("\nmq-135");
  Serial.println(digitalRead(2));
  Firebase.setInt("Mq135",digitalRead(2));
  delay(1000);
  Serial.print("Temperature = ");
  Serial.println(t);
  Firebase.setInt("Temp",t);
  Serial.print("Humidity = ");
  Serial.println(h);
  Firebase.setInt("Hum",h);
  delay(1000);
}
