# 🏥 TakeCare

An innovative mobile application for health diagnosis and monitoring, developed in **native Android** with secure authentication and intelligent medical recommendations.

## 📋 Description

**TakeCare** is an Android application that allows users to:

- ✅ Perform health diagnostics through an intelligent question system
- ✅ Track and visualize their current health status
- ✅ Connect with medical specialists
- ✅ Secure access through Google Sign-In and email authentication

The application uses a **medical decision tree** to provide preliminary diagnoses based on symptoms, helping users better understand their health condition before consulting with a professional.

## ✨ Key Features

### 🔐 Secure Authentication
- Google Sign-In using Firebase Authentication
- Email authentication
- Secure management of user credentials

### 🩺 Intelligent Diagnostic System
- Interactive symptom-based questionnaire
- Medical decision tree with over 40 questions
- Real-time preliminary diagnoses
- Result storage in SharedPreferences

### 📊 Health Tracking
- Visualization of current health status
- Diagnosis history
- Firebase Firestore integration

### 👨‍⚕️ Specialist Contact
- Interface to contact doctors
- Multiple communication channels (WhatsApp, phone, email)
- Specialist directory

### 🎨 Intuitive Design
- Material Design 3 interface
- Compatible with Android 6.0+ (API 23)
- Responsive design for different screen sizes

## 🔧 Prerequisites

Before installing TakeCare, make sure you have:

- **Android Studio** (recommended version: Android Studio Giraffe or higher)
- **JDK 11** or higher
- **Android SDK** with minimum API level 23
- **Gradle** (included in Android Studio)
- A **Firebase account** configured with:
  - Authentication (Google Sign-In)
  - Cloud Firestore Database

## 🚀 Installation

### Step 1: Clone the Repository

```bash
git clone https://github.com/yourusername/TakeCare.git
cd TakeCare
```

### Step 2: Configure Firebase

1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Create a new project or use an existing one
3. Download the `google-services.json` file from your project settings
4. Place the file in the `/app/` directory

### Step 3: Configure Google Sign-In

1. In Firebase Console, go to **Authentication** > **Sign-in method**
2. Enable **Google** as a provider
3. Get your `Web Client ID` and update the value in `strings.xml`:

```xml
<string name="default_web_client_id">YOUR_WEB_CLIENT_ID</string>
```

### Step 4: Build the Project

```bash
./gradlew build
```

### Step 5: Run the Application

- Connect an Android device or use an emulator
- Press `Run` in Android Studio or execute:

```bash
./gradlew installDebug
```

## 📁 Project Structure

```
TakeCare/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/takecare/
│   │   │   │   ├── SplashScreen.java           # Splash screen
│   │   │   │   ├── Login.java                  # Login screen
│   │   │   │   ├── CorreoLogin.java            # Email login
│   │   │   │   ├── Home.java                   # Main screen
│   │   │   │   ├── Diagnostico.java            # Diagnostic system
│   │   │   │   ├── EstadoSalud.java            # Health status display
│   │   │   │   └── ContactarEspecialista.java  # Doctor contact
│   │   │   ├── res/
│   │   │   │   ├── layout/                     # UI XML files
│   │   │   │   ├── drawable/                   # Graphical resources
│   │   │   │   ├── values/                     # Strings and colors
│   │   │   │   └── mipmap/                     # App icons
│   │   │   └── AndroidManifest.xml             # App configuration
│   │   └── test/                               # Unit tests
│   ├── build.gradle.kts                        # Gradle configuration
│   └── google-services.json                    # Firebase configuration
├── gradle/
│   └── libs.versions.toml                      # Dependency versions
├── build.gradle.kts                            # Root configuration
└── settings.gradle.kts                         # Module configuration
```

---

## 💻 Usage

### 1. Welcome Screen (SplashScreen)
The application starts with a loading screen that presents TakeCare's visual identity.

### 2. Authentication (Login)
Users can log in via:
- **Google Sign-In**: Fast and secure authentication
- **Email**: Traditional registration and login

### 3. Main Screen (Home)
Once authenticated, the user accesses the main menu with three options:

#### 🩺 Perform Diagnosis
- Answer an interactive questionnaire
- The system analyzes your responses
- Receive a preliminary diagnosis based on your symptoms

#### 📊 View Health Status
- Visualize your diagnosis history
- Track your health progress
- Access personalized recommendations

#### 👨‍⚕️ Contact a Specialist
- Find specialized doctors
- Communicate through multiple channels:
  - 📱 WhatsApp
  - ☎️ Phone call
  - 📧 Email

---

## 🛠️ Technologies Used

| Technology | Description |
|-----------|------------|
| **Java** | Primary programming language |
| **Android SDK** | Android development framework |
| **Firebase Auth** | Secure user authentication |
| **Firebase Firestore** | Cloud NoSQL database |
| **Google Sign-In API** | Google authentication |
| **Material Design 3** | Modern design system |
| **AndroidX** | Compatibility libraries |
| **Glide** | Image loading and management |
| **Gradle** | Project build system |

### Main Dependencies

```kotlin
// Firebase
implementation(platform(libs.firebase.bom))
implementation(libs.firebase.analytics)
implementation(libs.google.firebase.auth)
implementation(libs.firebase.firestore)

// Google Sign-In
implementation(libs.play.services.auth)
implementation(libs.googleid)

// UI & Material Design
implementation(libs.appcompat)
implementation(libs.material)
implementation(libs.constraintlayout)

// Images
implementation(libs.glide)

// Authentication
implementation(libs.androidx.credentials)
implementation(libs.credentials.play.services.auth)
```

---

## 🔑 Environment Variables and Configuration

### `strings.xml` File
```xml
<resources>
    <string name="app_name">TakeCare</string>
    <string name="default_web_client_id">YOUR_GOOGLE_WEB_CLIENT_ID</string>
</resources>
```

### `build.gradle.kts` File (Module: app)
```kotlin
android {
    namespace = "com.example.takecare"
    compileSdk = 35
    
    defaultConfig {
        applicationId = "com.example.takecare"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}
```

---

## 📊 Diagnostic Algorithm

The diagnostic system uses a **binary decision tree** that:

1. **Starts** with general symptoms (fever, chills)
2. **Branches** into specific symptoms based on responses
3. **Categorizes** into 8 possible diagnoses:
   - Severe respiratory infection
   - Mild symptoms
   - Migraine
   - Urinary tract infection
   - Digestive problems
   - Cardiovascular symptoms
   - Severe neurological symptoms
   - Chronic diseases or recent trauma

Example questions include:
- Do you have a fever?
- Do you have difficulty breathing?
- Do you feel chest pain?
- Have you experienced seizures?

---

## 🔒 Security

TakeCare implements multiple layers of security:

✅ **Secure authentication** with Firebase Authentication
✅ **Encrypted data** in transit (HTTPS)
✅ **Data validation** on client and server
✅ **Firestore rules** for access control
✅ **ProGuard** enabled for code obfuscation
✅ **Minimal permissions** requested from users

---

## 🚦 Required Permissions

```xml
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
```

---

## 🐛 Report Issues

If you find a bug or have suggestions:

1. Open an [Issue](https://github.com/AlanAguirre21/Interacci-onHC/issues) on GitHub
2. Clearly describe the problem
3. Include steps to reproduce it
4. Attach screenshots if necessary

---

## 🤝 Contributions

Contributions are welcome! To collaborate:

1. **Fork** the repository
2. Create a branch for your feature (`git checkout -b feature/AmazingFeature`)
3. Make your changes
4. **Commit** with descriptive messages (`git commit -m 'Add AmazingFeature'`)
5. **Push** to the branch (`git push origin feature/AmazingFeature`)
6. Open a **Pull Request**

### Code Standards
- Follow Java naming conventions
- Use Android Studio with code inspections enabled
- Comment complex code
- Include your changes in the documentation

---

## 📝 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments

- Firebase for the backend platform
- Material Design for design philosophy
- Android community for best practices

---

## 📧 Contact

For inquiries or more information:

- **GitHub**: [@yourusername](https://github.com/AlanAguirre21)

---

## 📚 Useful Resources

- [Official Android Documentation](https://developer.android.com/)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Material Design Guidelines](https://material.io/design)
- [Android Architecture Patterns](https://developer.android.com/topic/architecture)

---

**Made with ❤️ for your health**

*Last updated: May 2025*
