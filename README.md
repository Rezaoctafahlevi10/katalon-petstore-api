# 🚀 Katalon PetStore API Automation Testing

Repository ini berisi project **API Automation Testing** menggunakan **Katalon Studio** dengan studi kasus **Swagger PetStore API** (`https://petstore.swagger.io/`). Project ini dirancang dengan menerapkan penggunaan **Dynamic Data**, **Global Variables**, serta mencakup pengujian menyeluruh pada skenario positif (*positive test*) dan negatif (*negative test*).

---

## 📂 Project Structure

Struktur direktori dan pengorganisasian *Test Cases* dalam project ini dibagi berdasarkan endpoint HTTP method:

- **Post Pet**
  - `TC_001_Created Pet Succes`
  - `TC_002_Created Pet Succes`
- **Delete Pet**
  - `TC_001_Delete_Pet_By_Id_Succes`
  - `TC_002_Deleted_Pet_By_Id_Invalid`
- **Get Pet**
  - `TC_001_Get_Pet_By_Id_Succes`
  - `TC_002_Get_Pet_By_Id_Invalid`
- **Put Pet**
  - `TC_001_Put Pet Succes`
  - `TC_001_Put Pet Invalid`
- **E2E Flow**
  - `TC_001_E2E_PET`

---

## 🧪 Test Coverage & Requirements

Project ini memenuhi standar kriteria pengujian API otomatis dengan cakupan sebagai berikut:
* **Minimum 4 Endpoint utama diuji:**
  1. `POST /v2/pet` (Membuat data pet baru)
  2. `PUT /v2/pet` (Memperbarui data pet)
  3. `GET /v2/pet/{petId}` (Mencari pet berdasarkan ID)
  4. `DELETE /v2/pet/{petId}` (Menghapus pet berdasarkan ID)
* **Positive & Negative Test:** Setiap endpoint dilengkapi dengan skenario uji sukses dan uji gagal.
* **End-to-End (E2E) Flow:** Terdapat skenario alur terintegrasi dari awal pembuatan hingga penghapusan data.
* **Dynamic Data & Global Variables:** Menggunakan data acak (*random integer*) dan `GlobalVariable` agar data uji selalu dinamis dan tidak *hardcode*.
* **Assertions:** Setiap *test case* dilengkapi validasi otomatis untuk **HTTP Status Code** dan **Response Body/Message**.

---

## ⚙️ Cara Menjalankan Project

1. Buka aplikasi **Katalon Studio**.
2. Pilih menu **File > Open Project**, lalu arahkan ke folder repository project ini (`katalon-petstore-api`).
3. Tunggu hingga project selesai dimuat (*loading*).
4. Untuk menjalankan pengujian secara menyeluruh:
   * Buka folder **Test Suites** di panel *Test Explorer*.
   * Pilih dan buka *Test Suite* yang ingin dijalankan.
   * Klik tombol **Run** (ikon Play berwarna hijau) di bagian atas toolbar Katalon Studio.
5. Setelah eksekusi selesai, Anda dapat melihat hasil laporan (*report*) pengujian langsung di tab **Log Viewer** atau melalui panel *Results*.

---

## 🔒 Security Note
Repository ini publik/aman karena tidak menyertakan informasi sensitif seperti *password*, *token*, *API key*, ataupun *secret key* apa pun.
