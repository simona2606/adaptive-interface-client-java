# Adaptive Interface News Client Java 🔶

***Adaptive Interface News***, or **NIA**, is an application that enables the browsing of news from various newspapers, providing support for people with visual impairments in a way that makes it easier for them to use the application.
The application performs two main functions:
* Retrieves news via API calls from https://newsapi.org
* Interacts with a server hosted on a personal machine to manage the persistence of user input, login, and registration information.

It is possible during the account registration phase to select which visual anomalies you are afflicted with by being able to choose from: **low vision**, **deuteranopia**, **deuteranomaly**, and **achromatopsia**.

The colors of the application vary according to the selected abnormality also involving images retrieved from the internet. Specifically, for each case we treat, we have the following color palettes:
* LOW VISION: For the color palette in the case of low vision or no visual abnormality, we used:
  ```
  <color name="primary_light">#FFCCBC</color> 
     <color name="primary_dark">#E64A19</color> 
     <color name="primary">#FF5722</color>
     <color name="accent_color">#607D8B</color> 
     <color name="secondary_text">#757575</color> 
     <color name="divider_color">#BDBDBD</color> ```
 While to edit the images we applied the following grid:
 ```
 private static final float[] NORMAL = { 
      1,0,0,0,0,
      0,1,0,0,0, 
      0,0,1,0,0, 
      0,0,0,1,0, 
      0,0,0,0,1
  };```
