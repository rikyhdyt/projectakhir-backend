package com.bcafinace.projectakhir.utils;

public class ConstantMessage {

    /*
    Memperbolehkan nilai numerik dari 0 hingga 9.
    Memperbolehkan Huruf besar dan huruf kecil dari a sampai z.
    Yang diperbolehkan hanya garis bawah “_”, tanda hubung “-“ dan titik “.”
    Titik tidak diperbolehkan di awal dan akhir local part (sebelum tanda @).
    Titik berurutan tidak diperbolehkan.
    Local part, maksimal 64 karakter.
     */
//    public final static String REGEX_EMAIL_STRICT = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";

    /*REGEX*/
    public final static String REGEX_PHONE = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
    /*
    * Tidak memperbolehkan tanda | (pipa) dan ' (petik 1)
    */
    public final static String REGEX_EMAIL_STANDARD_RFC5322  = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public final static String REGEX_DATE_YYYYMMDD  = "^([0-9][0-9])?[0-9][0-9]-(0[0-9]||1[0-2])-([0-2][0-9]||3[0-1])$";
    public final static String REGEX_DATE_DDMMYYYY  = "^([0-2][0-9]||3[0-1])-(0[0-9]||1[0-2])-([0-9][0-9])?[0-9][0-9]$";

    /*Global*/
    public final static String SUCCESS_SAVE = "DATA BERHASIL DIBUAT";
    public final static String SUCCESS_FIND_BY = "OK";
    public final static String WARNING_NOT_FOUND = "DATA TIDAK DITEMUKAN";
    public final static String WARNING_LOGIN_FAIL = "LOGIN GAGAL";
    public final static String WARNING_DATA_EMPTY = "DATA TIDAK ADA";

    public final static String ERROR_DATA_INVALID = "DATA TIDAK VALID";
    public final static String ERROR_INTERNAL_SERVER = "INTERNAL SERVER ERROR";
    public final static String ERROR_MAIL_FORM_JSON = "Malformed JSON request";
    public final static String ERROR_EMAIL_FORMAT_INVALID = "FORMAT EMAIL TIDAK SESUAI (Nomor/Karakter@Nomor/Karakter)";
    public final static String ERROR_PHONE_NUMBER_FORMAT_INVALID = "FORMAT NOMOR HANDPHONE TIDAK SESUAI (+628XX-)";
    public final static String ERROR_DATE_FORMAT_YYYYMMDD = "FORMAT TANGGAL TIDAK SESUAI (YYYY-mm-dd)";

    public final static String ERROR_UNEXPECTED = "UNEXPECTED ERROR";
    public final static String ERROR_UNPROCCESSABLE = "Validation error. Check 'errors' field for details.";

    public final static String ERROR_NO_CONTENT = "PERMINTAAN TIDAK DAPAT DIPROSES";
    public final static String WELCOME_MESSAGE = "This is Springboot BootCamp BCAF BATCH 1";
    public final static String TAKE_TOUR = "Ready To Start";

    /*Customer*/
    public final static String SUCCESS = "";
    public final static String ERROR = "";
    public final static String WARNING_EMAIL_EXIST = "EMAIL SUDAH TERDAFTAR";
    public final static String WARNING_CUSTOMER_NOT_FOUND = "CUSTOMER BELUM TERDAFTAR";

    /*Products*/
    public final static String WARNING_PRODUCT_NOT_FOUND = "PRODUK TIDAK DITEMUKAN";
    public final static String WARNING_PRODUCT_PRICE_SOP = "HARGA TIDAK BOLEH 1/2 ATAU 3 KALI DARI HARGA SEBELUMNYA";

    /*Cars*/
    public final static String WARNING_NUM_EXIST = "NOMOR POLISI SUDAH TERDAFTAR";
    public final static String WARNING_CAR_NOT_FOUND = "MOBIL BELUM TERDAFTAR";
    public final static String WARNING_CARNUM_NAME_MANDATORY = "NOMOR POLISI WAJIB DIISI";
    public final static String WARNING_CARTYPE_MANDATORY = "TIPE MOBIL WAJIB DIISI";
    public final static String WARNING_CARBRAND_MANDATORY = "MEREK MOBIL WAJIB DIISI";
    public final static String WARNING_CARCOLOR_MANDATORY = "WARNA MOBIL WAJIB DIISI";
    public final static String WARNING_CARYEAR_MANDATORY = "TAHUN MOBIL WAJIB DIISI";


    //regis
    public final static String SUCCESS_SEND_EMAIL = "SILAHKAN CEK EMAIL YANG TELAH ANDA DAFTARKAN";

    public final static String WARNING_EMAIL_NOT_FOUND = "OTENTIFIKASI GAGAL";
    public final static String SUCCESS_FIND_TOKEN = "EMAIL VALID";

    //category
    public final static String WARNING_CAT_NAME_MANDATORY = "NAMA CATEGORY WAJIB DIISI";
    public final static String WARNING_NAME_MAX_LENGTH = "MAKSIMAL NAMA 25 KARAKTER";

    public final static String WARNING_DESC_NAME_MANDATORY = "NAMA DESKRIPSI WAJIB DIISI";
    public final static String WARNING_DESC_MAX_LENGTH = "MAKSIMAL DESKRIPSI 50 KARAKTER";

    //csv
    public final static String CONTENT_TYPE_CSV = "text/csv";
    public final static String ERROR_NOT_CSV_FILE = "FORMAT FILE HARUS CSV ";
    public final static String ERROR_UPLOAD_CSV = "UPLOAD FILE GAGAL ";

    //rent
    public final static String WARNING_DATA_MANDATORY = "SEMUA DATA WAJIB DIISI";
    public final static String WARNING_DATA_MAX_LENGTH = "DATA TERLALU PANJANG";

    //rekening
    public final static String WARNING_REK_EXIST = "REKENING SUDAH TERDAFTAR";
    public final static String WARNING_REK_SUMBER_NOT_EXIST = "REKENING SUMBER TIDAK TERDAFTAR";
    public final static String SUCCESS_CEK_BY = "SALDO MENCUKUPI";
    public final static String WARNING_CEK_FAILED = "SALDO TIDAK MENCUKUPI";
    public final static String WARNING_REK_PENERIMA_NOT_EXIST = "REKENING PENERIMA TIDAK TERDAFTAR";
    public final static String WARNING_FAIL_TRANSACTION = "TRANSAKSI GAGAL";
    public final static String SUCCESS_TRANSFER = "TRANSFER BERHASIL";

    //ujian
    public final static String ERROR_TIDAK_BOLEH_KOSONG_VAR_1 = "VAR 1 HARUS DIISI";
    public final static String ERROR_TIDAK_BOLEH_KOSONG_VAR_2 = "VAR 2 HARUS DIISI";
    public final static String ERROR_TIDAK_BOLEH_KOSONG_VAR_3 = "VAR 3 HARUS DIISI";

}
