# Adaptive Interface News Client Java 🔶

***Adaptive Interface News***, or **NIA**, is an application that enables the browsing of news from various newspapers, providing support for people with visual impairments in a way that makes it easier for them to use the application.
The application performs two main functions:
* Retrieves news via API calls from https://newsapi.org
* Interacts with a server hosted on a personal machine to manage the persistence of user input, login, and registration information.

It is possible during the account registration phase to select which visual anomalies you are afflicted with by being able to choose from: **low vision**, **deuteranopia**, **deuteranomaly**, and **achromatopsia**.

The colors of the application vary according to the selected abnormality also involving images retrieved from the internet. Specifically, for each case we treat, we have the following color palettes:
* LOW VISION: for the color palette in the case of low vision or no visual abnormality, we used:
  ```
     <color name="primary_light">#FFCCBC</color> 
     <color name="primary_dark">#E64A19</color> 
     <color name="primary">#FF5722</color>
     <color name="accent_color">#607D8B</color> 
     <color name="secondary_text">#757575</color> 
     <color name="divider_color">#BDBDBD</color> 
  ```
     While to edit the images we applied the following grid:
     ```
     private static final float[] LOW VISION = { 
          1,0,0,0,0,
          0,1,0,0,0, 
          0,0,1,0,0, 
          0,0,0,1,0, 
          0,0,0,0,1
      };
  
* DEUTERANOPY: for the color palette in the case of deuteranopia, we used:
  ```
    <color name="primary_light_deuteranopia">#F2CAB3</color> 
    <color name="primary_dark_deuteranopia">#9E7600</color> 
    <color name="primary_deuteranopia">#B38600</color>
    <color name="accent_color_deuteranopia">#6E6B81</color>
    <color name="secondary_text_deuteranopia">#74676B</color> 
    <color name="divider_color_deuteranopia">#C6AFB6</color>
  ```
   While to edit the images we applied the following grid:
   ```
   private static final float[] DEUTERANOPY = { 
        0.625f,0.375f,0,0,0,
        0.7f,0.3f,0,0,0, 
        0,0.3f,0.7f,0,0, 
        0,0,0,1,0, 
        0,0,0,0,1
    };
    ```
* DEUTERANOMALY: for the color palette in the case of deuteranomaly, we used:
  ```
    <color name="primary_light_deuteranomaly">#F6C9B3</color> 
    <color name="primary_dark_deuteranomaly">#B9680F</color> 
    <color name="primary_deuteranomaly">#D17613</color>
    <color name="accent_color_deuteranomaly">#676D81</color> 
    <color name="secondary_text_deuteranomaly">#71686A</color> 
    <color name="divider_color_deuteranomaly">#C0B1B6</color>
  ```
  While to edit the images we applied the following grid:
  ```
   private static final float[] DEUTERANOMALY = { 
        0.8f,0.2f,0,0,0,
        0.258f,0.742f,0,0,0, 
        0,0.142f,0.858f,0,0, 
        0,0,0,1,0,
        0,0,0,0
    };
    ```
* ACHROMATOPSIA: for the color palette in the case of achromatopsia, we used:
  ```
    <color name="primary_light_mono">#E3CFC9</color>
    <color name="primary_dark_mono">#955E50</color> 
    <color name="primary_mono">#A96D5D</color>
    <color name="accent_color_mono">#636D72</color> 
    <color name="secondary_text_mono">#6A6A6A</color> 
    <color name="divider_color_mono">#B5B5B5</color>
  ```
  While to edit the images we applied the following grid:
  ```
  private static final float[] ACHROMATOPSIA = { 
      0.299f,0.587f,0.114f,0,0,
      0.299f,0.587f,0.114f,0,0, 
      0.299f,0.587f,0.114f,0,0,
      0,0,0,1,0,
      0,0,0,0,1
  };
  ```


