#include <SPI.h>
#include <Wire.h>
#include <MPU6050.h>
#include <math.h>
// Pitch, Roll and Yaw values
float pitch = 0;
float roll = 0;
float counter = 0.0;
MPU6050 mpu;
// Timers
unsigned long timer = 0;
float timeStep = 0.01;
void setup() {
Serial.begin(9600);
  //--------------------------     IMU    --------------------------
  // Initialize MPU6050
  if(!mpu.begin(MPU6050_SCALE_2000DPS, MPU6050_RANGE_2G)) {
    Serial.println("Could not find a valid MPU6050 sensor, check wiring!");
    delay(500);
  }

  mpu.calibrateGyro();
  // Set threshold sensivty. Default 3.
  mpu.setThreshold(4);
 

  delay(1);
  Serial.println("E");
}

void loop() {
  // put your main code here, to run repeatedly:
  timer = millis();

  //--------------------------     IMU    --------------------------
  // Read normalized values
  Vector mpu_norm = mpu.readNormalizeGyro();
  

  // Calculate Pitch, Roll and Yaw
  pitch = pitch + mpu_norm.YAxis * timeStep;
  roll = roll + mpu_norm.XAxis * timeStep;


  // Output in Serial
  float prevpitch = 0;
  float prevroll = 0;
  float pitchchange = prevpitch - pitch;
  float rollchange = prevroll - roll;
  if (abs(pitchchange) > abs(rollchange)) {
  if (pitchchange < -3) {
    Serial.print("L");
  }
  else if (pitchchange > 6) {
    Serial.print("R");
  }}
  else if (abs(pitchchange) < abs(rollchange)) {
  if (rollchange < (-3.0+counter)) {
    Serial.print("F");
    counter += 0.01;
  }
  else if (rollchange > (7.0+counter)) {
    Serial.print("B");
    counter += 0.01;
  }}
  prevpitch = pitch;
  prevroll = roll;
  delay(10);
}
