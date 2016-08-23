# Android Radar
The simple way to make radar in your Android app.
<p align="center">
<img src="https://github.com/karamsa/android-radar/blob/master/screen_1.png"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://github.com/karamsa/android-radar/blob/master/screen_2.png"/>

</p>

### Installation:

1) Go to:
  
File -> Import Module -> choose the folder "android-radar-master".

2) add this to your gradle file :
```java
	compile project(':android-radar-master')
```
### Usages:

In your xml import an extra namespace on the root of your layout for example "whatever", like this:
```xml
	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:whatever="http://schemas.android.com/apk/res-auto"
	    >
	    ....
	    <!-- Your actual layout -->
	    ....
	</LinearLayout>
```
Whenever you need to use the Radar just do the following in your xml.
```xml
    <co.geeksters.radar.Radar
        android:id="@+id/radar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        />
 ```
    
In your activity, to create points or pin in this radar: 
```java
    radar = (co.geeksters.radar.Radar) findViewById(R.id.radar);
    
    //And here set the reference Point (or for exemple your GPS location)
    radar.setReferencePoint(new RadarPoint("myLocation", 10.00000f,22.0000f));
    
    // the other points in the Radar
    ArrayList<RadarPoint> points = new ArrayList<RadarPoint>();

    points.add(new RadarPoint("identifier1", 10.00200f,22.0000f));
    points.add(new RadarPoint("identifier2", 10.00220f,22.0000f));
    points.add(new RadarPoint("identifier3", 10.00420f,22.0010f));
    
    radar.setPoints(points);
```
That's is all :) 

#### Advenced usages:

Other Attributes:
```xml
    whatever:center_pin_radius="20" // Radius of the pin in the center
    whatever:pins_radius="20" // Radius of pins on the Radar
    whatever:pins_color="@color/light_green" // Color of pins on the Radar
    whatever:center_pin_color="@color/fourth_color" // Color of the pin in the center
  
    whatever:radar_image="@drawable/radar_background" // image of the radar
    whatever:pins_image="@drawable/pin" // pins icon
    whatever:center_pin_image="@drawable/center_pin" //  center pin icon
  
    whatever:max_distance="-1" //  Max distance by metters to cover, -1 to infinit, default velue is 10000

```

  

#### handle clicks:

To handle Pin's clicks on the Radar:
```java
    radar.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
          String pinIdentifier = radar.getTouchedPin(event);
          if (pinIdentifier != null) {
              Toast.makeText(thisActivity, pinIdentifier, Toast.LENGTH_SHORT).show();
          }
          return true;
      }
    });
 ```  
PS: This will not include the center pin.
 
#### Refresh the radar:
After changes you can call refresh method to remake the Radar:
```java
    radar.refresh();
```
