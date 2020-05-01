#include <Adafruit_Sensor.h>
#include <DHT.h>
#include <DHT_U.h>
#include "WiFiServer.h"
#ifndef __CC3200R1M1RGC__
#include <SPI.h>
#endif
#include <WiFi.h>     

#define DHTPIN            18         

#define DHTTYPE           DHT11  
   
char ssid[] = "your ssid";
char password[] = "password";
int c=0;
DHT_Unified dht(DHTPIN, DHTTYPE);

WiFiServer server(80);
uint32_t delayMS;
const int a = A1;
const int b = A2;

int mq2 = 0;
int mq135 = 0;
void setup() {
  Serial.begin(9600); 
  dht.begin();
  Serial.println("Welcome");
   sensor_t sensor;
   dht.temperature().getSensor(&sensor);
   dht.humidity().getSensor(&sensor);
   delayMS = sensor.min_delay / 1000; 
   Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);
 
  WiFi.begin(ssid, password);
 
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected");
 
  // Start the server
  server.begin();
  Serial.println("Server started");
 
  // Print the IP address
  Serial.print("Use this URL to connect: ");
  Serial.print("http://");
  Serial.print(WiFi.localIP()); 

  Serial.println("/");
}

void loop() { 
  WiFiClient client = server.available();
  if (!client) {
    return;
  }
 int t,h;
  Serial.println("new client");
  while(!client.available()){
    delay(1);
  }
 
  // Read the first line of the request
  String request = client.readStringUntil('\r');
  Serial.println(request);
  client.flush();
    client.println();
    client.println("<html><head><title>Welcome</title></head></head><body align=center>");
    
    client.println("<h1 align=center><font color=\"red\">Welcome</font></h1>");
    
    sensors_event_t event;  
    dht.temperature().getEvent(&event);
    t=event.temperature;
    dht.humidity().getEvent(&event);
    h=event.relative_humidity;
    mq2 = analogRead(a);
    mq135 = analogRead(b);
    
    if(mq135>30 && mq135<700 && mq2>30 && mq2<450 && t>20 && t<38 && h>30 && h<90){
      client.println("<h1 align=center><font color=\"red\">This Place is Safe</font></h1>");
    }else{
      
      client.println("<h1 align=center><font color=\"red\">This Place is Not Safe</font></h1>");
    }
    delay(delayMS);
    
    client.println();
    client.println();
    client.println();
    client.println();
    delay(2000);
  
  
}
