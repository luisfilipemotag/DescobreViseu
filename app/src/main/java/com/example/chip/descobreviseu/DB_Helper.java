package com.example.chip.descobreviseu;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/* Created by Chip on 27/02/2017.
 */

public class DB_Helper extends SQLiteOpenHelper  {
    private static final String LOG = "DatabaseHelper";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DescobreViseu";

    private static final String Table_Turista = "Turista";
    private static final String TABLE_Premio = "Premio";
    private static final String TABLE_Monumento = "Monumento";

    //table turista
    private static final String KEY_ID_turista = "ID_turista";
    private static final String KEY_Nacionalidade = "Nacionalidade";
    private static final String KEY_Nome = "Nome";
    private static final String KEY_P_turista = "P_turista";
    //table Premio
    private static final String KEY_id_premio = "id_premio";
    private static final String KEY_pontos_P = "pontos_P";
    private static final String KEY_Quantidade  = "Quantidade";
    private static final String KEY_estado  = "estado";
    private static final String KEY_nome_Premio  = "nome_Premio";
    //table monumento
    private static final String KEY_ID_monumento = "ID_monumento";
    private static final String KEY_Nome_m = "Nome_m";
    private static final String KEY_Descricao = "Descricao";
    private static final String KEY_Pontos_M  = "Pontos_M";
    private static final String KEY_Lat = "Lat";
    private static final String KEY_Long  = "Long";
    private static final String KEY_Estado_vista  = "Estado_vista";
    private static final String KEY_Cod_scanQR  = "Cod_scanQR";



    private static final String CREATE_TABLE_Turista = "CREATE TABLE "
            + Table_Turista + "(" + KEY_ID_turista + " INT PRIMARY KEY," + KEY_Nacionalidade
            + " VARCHAR (70)," + KEY_Nome + " VARCHAR (50)," + KEY_P_turista
            + "  INT DEFAULT (0) CHECK (P_turista >= 0))";

    private static final String CREATE_TABLE_Premio = "CREATE TABLE "
            + TABLE_Premio + "(" + KEY_id_premio + " INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," + KEY_pontos_P
            + " INT NOT NULL," + KEY_Quantidade + "  INT NOT NULL," + KEY_estado
            + "  INT (3) NOT NULL CHECK (estado IN (0, 1, 2) ) DEFAULT (0) ," +KEY_nome_Premio+" VARCHAR (70) NOT NULL "+")";

    private static final String CREATE_TABLE_Monumento = "CREATE TABLE "
            + TABLE_Monumento + "(" + KEY_ID_monumento + " INTEGER NOT NULL  PRIMARY KEY AUTOINCREMENT UNIQUE," +KEY_Nome_m
            + " VARCHAR (70)," + KEY_Descricao + " TEXT," + KEY_Pontos_M
            + "  INT NOT NULL ,"+ KEY_Lat +" VARCHAR(30) ," + KEY_Long +" VARCHAR(30), "+ KEY_Estado_vista +" INT (3) DEFAULT (0), "+ KEY_Cod_scanQR +" INT NOT NULL UNIQUE"+ ")";

    public DB_Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_Turista);
        db.execSQL(CREATE_TABLE_Premio);
        db.execSQL(CREATE_TABLE_Monumento);
        ///pinserir dados para DB
        //monumentos
        String ROW1 ="INSERT INTO "+ TABLE_Monumento +" ("+KEY_ID_monumento+","+KEY_Nome_m+","+ KEY_Descricao+","+ KEY_Pontos_M +","+KEY_Lat+","+KEY_Long+","+KEY_Cod_scanQR+" , "+KEY_Estado_vista+") VALUES (1,'praca da republica', 'A Praça da República apresenta-se como o principal núcleo da cidade desde 1886. Conhecida como Rossio, esta praça distingue-se pelas suas valências administrativas e económicas presentes nos edifícios da Câmara Municipal, datado dos finais do século XIX, do Banco de Portugal, de 1930, e da Caixa Geral de Depósitos. No Rossio encontramos ainda uma alegoria ao mundo rural, representada num painel de azulejos datado de 1930 e da autoria de Joaquim Lopes, onde não podemos deixar de observar a emblemática figura da Capucha.',10,'40.65753','-7.914175',1,0)";
        String ROW2 ="INSERT INTO "+ TABLE_Monumento +" ("+KEY_ID_monumento+","+KEY_Nome_m+","+ KEY_Descricao+","+ KEY_Pontos_M +","+KEY_Lat+","+KEY_Long+","+KEY_Cod_scanQR+" , "+KEY_Estado_vista+") VALUES (2,'museu de almeida moreira','Visitar o Museu de Almeida Moreira é descobrir a alma de uma das mais entusiasmantes personagens do século XX viseense. Fundador e primeiro diretor do Museu de Grão Vasco, Francisco Almeida Moreira manifestou, desde cedo, uma profunda dedicação à arte e ao colecionismo. Este museu, situado na Rua do Soar de Cima e em frente ao Jardim das Mães, conta no seu acervo com um conjunto diversificado de peças, passando pela pintura e escultura da época Moderna.',10,'40.65847','-7.913308',2,0)";
        String ROW3 ="INSERT INTO "+ TABLE_Monumento +" ("+KEY_ID_monumento+","+KEY_Nome_m+","+ KEY_Descricao+","+ KEY_Pontos_M +","+KEY_Lat+","+KEY_Long+","+KEY_Cod_scanQR+" , "+KEY_Estado_vista+") VALUES (3,'jardim das maes','No Largo Major Teles, paredes meias com o Museu de Almeida Moreira, encontramos um jardim com tonalidades deslumbrantes oferecidas por uma vegetação única. Ao centro do jardim encontra-se uma escultura de 1940, da autoria de Oliveira Ferreira, dedicada à sua mãe e intitulada “O melhor sono da nossa vida”. José de Oliveira Ferreira foi discípulo de Soares dos Reis, tendo sido esta obra galardoada na XXVII Exposição da Sociedade Nacional de Belas-Artes de 1930, com o 2º lugar',15,'40.65818','-7.913489',3,0)";
        String ROW4 ="INSERT INTO "+ TABLE_Monumento +" ("+KEY_ID_monumento+","+KEY_Nome_m+","+ KEY_Descricao+","+ KEY_Pontos_M +","+KEY_Lat+","+KEY_Long+","+KEY_Cod_scanQR+" , "+KEY_Estado_vista+") VALUES (4,'igreja da ordem terceira de sFrancisco', 'Com uma vista privilegiada sobre toda a Praça da República, a igreja da Ordem Terceira de S. Francisco apresenta uma elegante escadaria que nos permite aceder a um dos mais belos exemplares da arquitetura religiosa da segunda metade do século XVIII. O seu interior encontra-se repleto de painéis de azulejos que retratam a vida de S. Francisco e de retábulos de feição rococó. Não deixe de admirar um magnífico órgão do século XVIII no coro alto.',20,'40.65630','-7.914436',4,0)";
        String ROW5 ="INSERT INTO "+ TABLE_Monumento +" ("+KEY_ID_monumento+","+KEY_Nome_m+","+ KEY_Descricao+","+ KEY_Pontos_M +","+KEY_Lat+","+KEY_Long+","+KEY_Cod_scanQR+" , "+KEY_Estado_vista+") VALUES (5,'catedral de santa maria de viseu', 'Com uma vista privilegiada sobre toda a Praça da República, a igreja da Ordem Terceira de S. Francisco apresenta uma elegante escadaria que nos permite aceder a um dos mais belos exemplares da arquitetura religiosa da segunda metade do século XVIII. O seu interior encontra-se repleto de painéis de azulejos que retratam a vida de S. Francisco e de retábulos de feição rococó. Não deixe de admirar um magnífico órgão do século XVIII no coro alto.',20,'40.65969','-7.910986',5,0)";
        String ROW6 ="INSERT INTO "+ TABLE_Monumento +" ("+KEY_ID_monumento+","+KEY_Nome_m+","+ KEY_Descricao+","+ KEY_Pontos_M +","+KEY_Lat+","+KEY_Long+","+KEY_Cod_scanQR+" , "+KEY_Estado_vista+") VALUES (6,'rua direita', 'Num dos pontos mais altos da cidade e a coroar uma das uma das mais belas praças do nosso país, encontramos a Catedral de Santa Maria de Viseu. Edificada nos inícios do século XII, associada a um paço condal e a um castelo, a Sé de Viseu sofreu, entre os séculos XIII e XVII, inúmeras transformações. No seu interior podemos observar o primeiro claustro renascentista de Portugal e uma magnifica “abóbada de nós” do século XVI, bem como o braço relicário de São Teotónio, primeiro santo português. No piso superior, na antiga Sala Capitular, encontramos o Museu dedicado ao Tesouro da Sé, cujo acervo retrata os mais de 900 anos da catedral e o Passeio dos Cónegos, uma loggia que oferece uma das mais belas vistas da cidade.',25,'40.65969','-7.910986',6,0)";
        String ROW7 ="INSERT INTO "+ TABLE_Monumento +" ("+KEY_ID_monumento+","+KEY_Nome_m+","+ KEY_Descricao+","+ KEY_Pontos_M +","+KEY_Lat+","+KEY_Long+","+KEY_Cod_scanQR+" , "+KEY_Estado_vista+") VALUES (7,'rua formosa', 'A Rua Direita é a principal artéria comercial da cidade de Viseu. Com cerca de 500m de extensão, era há 2000 anos, no período romano, o principal eixo viário da cidade romana, o Cardus Maximus. Em época medieval era designada como a Rua das Tendas, por ser, tal como hoje, a principal rua comercial do burgo medieval. No século XV vê o seu nome alterado para Rua Direita, pelo facto de ligar diretamente duas das portas da cidade, a extinta porta de São José e a Porta dos Cavaleiros. Ao longo de toda rua são visíveis casas sobradas, casas senhoriais, janelas manuelinas e inúmeras lojas comerciais, fazendo com ainda hoje em dia se conseguia sentir a alma e o espírito do povo que lhe deu vida ao longo de quase dois mil anos de história.',15,'40.65759','-7.912619',7,0)";
        String ROW8 ="INSERT INTO "+ TABLE_Monumento +" ("+KEY_ID_monumento+","+KEY_Nome_m+","+ KEY_Descricao+","+ KEY_Pontos_M +","+KEY_Lat+","+KEY_Long+","+KEY_Cod_scanQR+" , "+KEY_Estado_vista+") VALUES (8,'parque', 'O parque Aquilino Ribeiro é um espaço convidativo, onde pode respirar ar puro, divertir-se, passear e fazer desporto. É o pulmão da cidade por excelência. Aprecie a explosão de cores, de aromas e da tranquilidade transmitida pelos cursos de água em movimento. Não deixe também de recordar Aquilino Ribeiro, um dos expoentes da literatura nacional, que, desde 1974, dá nome ao Parque. Convidamo-lo ainda a visitar a Capela da Senhora da Vitória, cuja edificação, no século XVII, pretendeu perpetuar a memória da vitória portuguesa nos campos de Aljubarrota.',20,'40.65528','-7.916014',8,0)";

        db.execSQL(ROW1);
        db.execSQL(ROW2);
        db.execSQL(ROW3);
        db.execSQL(ROW4);
        db.execSQL(ROW5);
        db.execSQL(ROW6);
        db.execSQL(ROW7);
        db.execSQL(ROW8);


        //premios
        String Prow1="INSERT INTO "+ TABLE_Premio +" ("+KEY_id_premio+","+KEY_pontos_P+","+ KEY_Quantidade+","+ KEY_estado +","+KEY_nome_Premio+") VALUES (1,45,2,0,'caneta')";
        String Prow2="INSERT INTO "+ TABLE_Premio +" ("+KEY_id_premio+","+KEY_pontos_P+","+ KEY_Quantidade+","+ KEY_estado +","+KEY_nome_Premio+") VALUES (2,50,2,0,'descontos')";
        String Prow3="INSERT INTO "+ TABLE_Premio +" ("+KEY_id_premio+","+KEY_pontos_P+","+ KEY_Quantidade+","+ KEY_estado +","+KEY_nome_Premio+") VALUES (3,40,2,0,'premio3')";
        String Prow4="INSERT INTO "+ TABLE_Premio +" ("+KEY_id_premio+","+KEY_pontos_P+","+ KEY_Quantidade+","+ KEY_estado +","+KEY_nome_Premio+") VALUES (4,50,2,0,'premio4')";
        String Prow5="INSERT INTO "+ TABLE_Premio +" ("+KEY_id_premio+","+KEY_pontos_P+","+ KEY_Quantidade+","+ KEY_estado +","+KEY_nome_Premio+") VALUES (5,50,2,0,'premio5')";
        String Prow6="INSERT INTO "+ TABLE_Premio +" ("+KEY_id_premio+","+KEY_pontos_P+","+ KEY_Quantidade+","+ KEY_estado +","+KEY_nome_Premio+") VALUES (6,300,2,0,'premio6')";
        db.execSQL(Prow1);
        db.execSQL(Prow2);
        db.execSQL(Prow3);
        db.execSQL(Prow4);
        db.execSQL(Prow5);
        db.execSQL(Prow6);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + Table_Turista);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Premio );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Monumento);

        // create new tables
        onCreate(db);
    }

    //TO DO---------------------//
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    public DB_Monumento getInfoMonumento(int cod_scan) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT "+KEY_ID_monumento+" , "+KEY_Nome_m+" , "+KEY_Pontos_M+" , "+KEY_Estado_vista+" FROM " + TABLE_Monumento + " WHERE "
                + KEY_Cod_scanQR + " = " + cod_scan;

        Log.e(LOG, selectQuery);

        String whereClause = KEY_Cod_scanQR+" = "+ cod_scan;
        String campos[]=new String[5];
        campos[0]=KEY_Nome_m ;
        campos[1]=KEY_ID_monumento ;
        campos[2]=KEY_Pontos_M ;
        campos[3]=KEY_Descricao;
        campos[4]=KEY_Estado_vista;

        Cursor c = db.query(TABLE_Monumento,campos,whereClause,null,null,null,null);
        c.moveToFirst();
        Log.d("count",String.valueOf(c.getCount()));

        if (c != null)
            c.moveToFirst();

            DB_Monumento td = new DB_Monumento();


            td.setID_monumento((c.getInt(c.getColumnIndex(KEY_ID_monumento))));
            td.setNome_m(c.getString(c.getColumnIndex(KEY_Nome_m)));
            td.setDescricao(c.getString(c.getColumnIndex(KEY_Descricao)));
            td.setPontos_M(c.getInt(c.getColumnIndex(KEY_Pontos_M)));
            td.setEstado_Visita(c.getInt(c.getColumnIndex(KEY_Estado_vista)));


        return td;
    }



    public  void nomeT(String nome) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery ="INSERT INTO "+ Table_Turista +" ("+KEY_ID_turista+" , "+KEY_Nome+" , "+KEY_P_turista+" ) VALUES ( 1, '"+nome+"' , 0)";
        Log.e(LOG, selectQuery);
        db.execSQL(selectQuery);


    }

    public  void updatePontos(int pontos){
        SQLiteDatabase db =this.getWritableDatabase();
        String selectQuery ="UPDATE "+ Table_Turista +" SET "+ KEY_P_turista +"="+pontos;
        Log.e(LOG, selectQuery);
        db.execSQL(selectQuery);


    }

    public  void updateEstadoM(int estado, int valor){
        SQLiteDatabase db =this.getWritableDatabase();
        String selectQuery ="UPDATE "+ TABLE_Monumento +" SET "+ KEY_Estado_vista +" = " + estado + " WHERE "+KEY_ID_monumento+" = " + valor ;
        Log.e(LOG, selectQuery);
        db.execSQL(selectQuery);


    }

    public  void Updatepremio( int id ){
        SQLiteDatabase db =this.getWritableDatabase();
        String selectQuery ="UPDATE "+ TABLE_Premio +" SET "+ KEY_estado +" = 1  WHERE "+KEY_id_premio+" = " + id ;
        Log.e(LOG, selectQuery);
        db.execSQL(selectQuery);


    }

    public  DB_Premio getPP( int id ){

        SQLiteDatabase db =this.getReadableDatabase();
        String selectQuery ="Select "+KEY_pontos_P+" FROM "+TABLE_Premio +" where "+ KEY_id_premio +" = "+id  ;
        Log.e(LOG, selectQuery);


        String campos[]=new String[1];
        campos[0]=KEY_pontos_P;
        Cursor c = db.query(TABLE_Premio,campos,null,null,null,null,null);
        c.moveToFirst();


        DB_Premio tb =new DB_Premio();
        tb.setPontos_P(c.getInt(c.getColumnIndex(KEY_pontos_P)));
        Log.e("nome turista",String.valueOf(tb.getPontos_P()));
        return tb;


    }


    public  void Resetpremio(){
        SQLiteDatabase db =this.getWritableDatabase();
        String selectQuery ="UPDATE "+ TABLE_Premio +" SET "+ KEY_estado +"=0";
        Log.e(LOG, selectQuery);
        db.execSQL(selectQuery);


    }

    public  DB_Turista PontosA(){

        SQLiteDatabase db =this.getReadableDatabase();
        String selectQuery ="Select "+KEY_P_turista+" FROM "+Table_Turista ;
        Log.e(LOG, selectQuery);


        String campos[]=new String[1];
        campos[0]=KEY_P_turista;
        Cursor c = db.query(Table_Turista,campos,null,null,null,null,null);
        c.moveToFirst();


        DB_Turista tb =new DB_Turista();
        tb.setP_turista(c.getInt(c.getColumnIndex(KEY_P_turista)));
        Log.e("pontos turista", String.valueOf(tb.getP_turista()));
        return tb;
    }

    public  DB_Turista bNome(){

        SQLiteDatabase db =this.getReadableDatabase();
        String selectQuery ="Select "+KEY_Nome+" FROM "+Table_Turista ;
        Log.e(LOG, selectQuery);


        String campos[]=new String[1];
        campos[0]=KEY_Nome;
        Cursor c = db.query(Table_Turista,campos,null,null,null,null,null);
        c.moveToFirst();


        DB_Turista tb =new DB_Turista();
        tb.setNome(c.getString(c.getColumnIndex(KEY_Nome)));
        Log.d("nome turista",tb.getNome());
        return tb;
    }

    public int getTurisa(){
        String countQuery = "SELECT  "+KEY_ID_turista+" FROM " + Table_Turista;
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.rawQuery(countQuery,null);
        int count = cursor.getCount();
        cursor.close();


        return count;
    }




    public List<DB_Monumento> listaMonumento() {
    List<DB_Monumento> monumento = new ArrayList<DB_Monumento>();
    String selectQuery = "SELECT " +KEY_Nome_m+" , "+KEY_ID_monumento + " FROM " + TABLE_Monumento;

  //  Log.e(LOG, selectQuery);

        SQLiteDatabase db =this.getReadableDatabase();
        String campos[]=new String[2];
        campos[0]=KEY_Nome_m;
        campos[1]=KEY_ID_monumento;
        Cursor c = db.query(TABLE_Monumento,campos,null,null,null,null,null);
        c.moveToFirst();


    if (c.moveToFirst()) {
        do {
            DB_Monumento DM = new DB_Monumento();
            DM.setNome_m(c.getString(c.getColumnIndex(KEY_Nome_m)));
            DM.setID_monumento(c.getInt(c.getColumnIndex(KEY_ID_monumento)));
            monumento.add(DM);
        } while (c.moveToNext());
    }

    return monumento;
}

    public List<DB_Premio> listaPremio0() {
        List<DB_Premio> Premio = new ArrayList<DB_Premio>();
        String selectQuery = "SELECT " +KEY_nome_Premio+" , "+KEY_id_premio + " FROM " + TABLE_Premio +" where " + KEY_estado + " = 1";


        SQLiteDatabase db =this.getReadableDatabase();
        String campos[]=new String[3];
        campos[0]=KEY_nome_Premio;
        campos[1]=KEY_id_premio;
        campos[2]=KEY_estado;
        String whereClause = "estado = 0 ";

        Cursor c = db.query(TABLE_Premio,campos,whereClause,null,null,null,null);
        c.moveToFirst();




        if (c.moveToFirst()) {
            do {
                DB_Premio DP = new DB_Premio();
                DP.setNome_Premio(c.getString(c.getColumnIndex(KEY_nome_Premio)));
                DP.setId_Premio(c.getInt(c.getColumnIndex(KEY_id_premio)));
                Premio.add(DP);
            } while (c.moveToNext());

        }


        return Premio;
    }

    public List<DB_Premio> listaPremio1() {
        List<DB_Premio> Premio = new ArrayList<DB_Premio>();
        String selectQuery = "SELECT " +KEY_nome_Premio+" , "+KEY_id_premio + " FROM " + TABLE_Premio +" where " + KEY_estado + " = 1";


        SQLiteDatabase db =this.getReadableDatabase();
        String campos[]=new String[3];
        campos[0]=KEY_nome_Premio;
        campos[1]=KEY_id_premio;
        campos[2]=KEY_estado;
        String whereClause = "estado = 1 ";

        Cursor c = db.query(TABLE_Premio,campos,whereClause,null,null,null,null);
        c.moveToFirst();




        if (c.moveToFirst()) {
            do {
                DB_Premio DP = new DB_Premio();
                DP.setNome_Premio(c.getString(c.getColumnIndex(KEY_nome_Premio)));
                DP.setId_Premio(c.getInt(c.getColumnIndex(KEY_id_premio)));
                Premio.add(DP);
            } while (c.moveToNext());

        }


        return Premio;
    }


    public DB_Monumento Mapa(long id){

        SQLiteDatabase db =this.getReadableDatabase();

        String selectQuery ="Select "+KEY_Nome_m+" , "+KEY_Lat+" , "+KEY_Long+" FROM "+TABLE_Monumento+" Where "+KEY_ID_monumento+" = "+id;
        Log.e(LOG, selectQuery);

        String campos[]=new String[3];
        campos[0]=KEY_Nome_m ;
        campos[1]=KEY_Lat ;
        campos[2]=KEY_Long ;

        Cursor c = db.query(TABLE_Monumento,campos,null,null,null,null,null);
        c.moveToFirst();
        Log.d("count",String.valueOf(c.getCount()));
        Log.e("valormapa", String.valueOf(c.getColumnIndex(KEY_Lat)));

        DB_Monumento tb= new DB_Monumento();
        tb.setLatitude(String.valueOf(c.getColumnIndex(KEY_Lat)));
        tb.setLongitude(String.valueOf(c.getColumnIndex(KEY_Long)));
        tb.setNome_m(String.valueOf(c.getColumnIndex(KEY_Nome_m)));

        return tb;
    }




}
