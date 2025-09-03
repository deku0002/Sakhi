# SAKHI - Hostel-Based New-Age Distributor App

**SAKHI** is a mobile Android application designed to make **reusable menstrual products** easily accessible and private for college girls. The app focuses on a **hostel-based pilot model**, where students can order products, receive AI-based recommendations, and pick them up securely via QR codes.  

---

## 🌟 Key Features

### Student Side
- Browse **product catalog** (4–5 reusable menstrual product brands)
- **AI-powered quiz** for product recommendation (TFLite model)
- Place **anonymous orders**
- **QR code pickup** for secure and private collection
- Track order history and impact metrics (e.g., pads saved from landfill)

### Distributor Side (Hostel Pilot)
- **Inventory management**
- **Approve/fulfill orders**
- Track **earnings and product impact**
- QR scanning for smooth order verification

---

## 🛠️ Tech Stack

| Layer | Technology / Language | Description |
|-------|--------------------|------------|
| Android Frontend | XML | UI design and layouts |
| Android App Backend | Java | App logic, QR integration, AI integration |
| Server Backend | Spring Boot (Java) | REST APIs for orders, authentication, inventory, QR verification |
| Database | MySQL / PostgreSQL (SQL) | Stores users, products, orders, and stock |
| AI/ML | TensorFlow Lite | Runs product recommendation quiz locally in app |
| QR Code | ZXing (Java) | QR code generation and scanning for pickup |

---

## 📂 Project Structure

app/
├── src/main/java/com/sakhi/
│ ├── activities/ # All screens: Student/Distributor dashboard, catalog, quiz, QR, inventory
│ ├── fragments/ # Dashboard fragments: Home, Catalog, Orders, Profile
│ ├── models/ # Data classes: User, Product, Order, QuizQuestion
│ ├── adapters/ # RecyclerView adapters for products, orders, quiz
│ ├── utils/ # Helpers: SharedPrefs, QRCode, AIRecommendation, Network
│ └── api/ # Backend API client, service, response models
├── res/ # UI layouts, drawables, colors, strings, styles
├── AndroidManifest.xml
├── build.gradle (Module)
└── build.gradle (Project)

yaml
Copy code

---

## 👥 Team Roles

| Team Member | Responsibility |
|------------|----------------|
| **Devansh** | Android app frontend & logic, student/distributor UI, integrates AI & QR features |
| **Akshay** | Spring Boot backend, APIs, database, QR validation, order & inventory management |
| **Ayush** | AI/ML: TensorFlow Lite quiz model for product recommendations |
| **Divesh** | QR code system: generation, scanning, backend integration, helper functions |

---

## 🚀 How It Works (MVP)

1. Student logs in → takes **AI quiz** → receives product recommendation  
2. Places order → app generates **QR code**  
3. Student goes to hostel pickup → distributor scans QR → hands over product  
4. Inventory and **impact metrics update automatically**

---

## 📌 Why SAKHI is Hackathon-Worthy

- **Privacy-first**: QR-based pickup keeps orders anonymous  
- **Tech-driven**: AI recommendations + automated backend  
- **Social impact**: Encourages sustainable menstrual products  
- **Scalable**: Starts with 1 hostel → expand to multiple hostels/campuses  

---

## 🔧 Setup & Installation

1. Clone the repository:  
   ```bash
   git clone https://github.com/yourusername/SAKHI.git
Open the project in Android Studio

Build and run the app on emulator or device

Connect Spring Boot backend (/backend) running on localhost or deployed server

Ensure AI TFLite model is in assets folder for local inference

📈 Future Enhancements
Add push notifications for order updates

Add gamification and eco-rewards for sustainable purchases

Expand to multiple hostels and nearby pharmacies

Improve AI model with more personalized recommendations

📄 License
This project is open-source under the MIT License.

yaml
Copy code

---

If you want, I can also make a **shorter, more visually attractive README** with **GIFs/screenshots placeholders, badges, and quick setup instructions** that looks super professional for GitHub hackathon submissions.  

Do you want me to do that version too?
