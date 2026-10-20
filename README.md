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
* **4 Endpoint utama diuji:**
  1. `POST /v2/pet` (Membuat data pet baru)
  2. `PUT /v2/pet` (Memperbarui data pet)
  3. `GET /v2/pet/{petId}` (Mencari pet berdasarkan ID)
  4. `DELETE /v2/pet/{petId}` (Menghapus pet berdasarkan ID)
* **Positive & Negative Test:** Setiap endpoint dilengkapi dengan skenario uji sukses dan uji gagal.
* **End-to-End (E2E) Flow:** Terdapat skenario alur terintegrasi dari awal pembuatan hingga penghapusan data.
* **Dynamic Data & Global Variables:** Menggunakan data acak (*random integer*) dan `GlobalVariable` agar data uji selalu dinamis dan tidak *hardcode*.
* **Assertions:** Setiap *test case* dilengkapi validasi otomatis untuk **HTTP Status Code** dan **Response Body/Message**.

---
## ✅ Covered Test Scenario
| Test Case Id | Deskripsi | Method | Status Code |
| :--- | :--- | :--- | :-- |
| TC_001_Created Pet Succes | Succes Created Pet | POST | 200 OK|
| TC_002_Created Pet Invalid | Gagal Created Pet | POST | 400 Bad Input|
| TC_001_Delete_Pet_By_Id_Succes | Succes Delete Pet | DELETE | 200 OK |
| TC_002_Delete_Pet_By_Id_Invalid| Gagal Delete Pet | DELETE | 404 Not Found |
| TC_001_Get_Pet_By_Id_Succes| Succes Get Pet | GET | 200 OK |
| TC_002_Get_Pet_By_Id_Invalid| Gagal Get Pet | GET | 404 Not Found |
| TC_001_Put Pet Succes | Succes Put Pet | PUT | 200 OK |
| TC_002_Put Pet Invalid| Gagal Put Pet | PUT | 400 Bad Input |
| TC_001_E2E_PET| Gagal Delete Pet | POST,GET,PUT,DELETE | 200 OK |

---
## 📋 Test Suites 
Test Suites (TS_001_PET) di dalam project ini digunakan untuk mengelompokkan dan menjalankan beberapa Test Cases secara berurutan dalam satu kali eksekusi.  Dalam test Suites ini terdapat 9 test case yang dijalankan dalam satu kali ekskusi. Cakupan dari Test Suite ini meliputi:   
1. Eksekusi Alur Otomatis (Automated Sequence Execution): Menjalankan test case positif, negatif, dan E2E secara terstruktur guna mencegah kegagalan akibat ketergantungan data (misalnya: menjalankan Test Case POST terlebih dahulu untuk menghasilkan pet_id yang valid sebelum menjalankan test case GET, PUT, atau DELETE).
2. Pelaporan Terpusat (Batch Reporting): Menghasilkan laporan eksekusi gabungan yang menampilkan status lulus/gagal (pass/fail) dari seluruh modul API secara bersamaan. Hasil Report dari Test Suites dapat dilihat pada link berikut : https://l1nk.dev/2ktt9wb
-------
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
- Repository ini publik/aman karena tidak menyertakan informasi sensitif seperti *password*, *token*, *API key*, ataupun *secret key* apa pun.
- Api dapat diakses pada: https://reqres.in
