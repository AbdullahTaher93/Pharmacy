package com.example.abdullah.pharmacy;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class product extends AppCompatActivity {

    String[][] Dataofproduct ={};
    String [] imgs={};
    ListView ls;
    public static String allda="";
    public static String allprudect="";
    public static String phatmacyID="";
    String postion;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);

        Intent intent=getIntent();
         postion = intent.getStringExtra(partionsofproducts.name);
        Toast.makeText(this, postion+" ",Toast.LENGTH_LONG).show();

        setdata(postion);



        ls=(ListView)findViewById(R.id.ls);
        ls.setAdapter(new adapter(this,Dataofproduct,imgs));



    }

    public void viewcartshow(View view){
        Intent intent =new Intent(this,Listofcartshop.class);
        startActivity(intent);


    }



    private void setdata(String part){

        if(part.equals("0")){   /* Dataofproduct = new String[][]{
                    {"ELIFEXIR PIEL CANELA GEL SPF15 150 ML", "Este tratamiento solar de Elifexir intensifica la producción de melanina y nutre la piel en profundidad para mejorar el bronceado.", "8,17€","1"},
                    {"FOTOULTRA 100 ISDIN SPOT PREVENT FUSIÓN FLUID SOLAR SPF50+ 50 ML", "Ayuda a prevenir alteraciones de pigmentacion debidas al sol. Piel altamente fotosensible.", "19,33€","9"}
                    , {"INNEOV DENSILOGY PACK 3 MESES 180 CÁPSULAS", "Densilogy es una innovadora solución por vía oral que contribuye a la síntesis de proteínas como la queratina y al mantenimiento normal del cabello.", "58,54€","10"}
                    , {"XHEKEN CAPILAR SUAVIZANTE ACONDICIONADOR 250ML", "Aplicar del mismo modo, seguidamente cubrir el cabello con una toalla o un gorro de ducha, dejar actuar de media a una hora.", "6,13€","6"},
                    {"ABEÑULA BLANCA", "Este desmaquillante cuenta en su base con varios productos que proporcionan un efecto lubricante aportando brillo y vitalidad a las pestañas.", "2,78€","8"}
            };*/
            Phatmacy(allda,allprudect);
              //  imgs = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5};


            }
else if (part.equals("1")){    /*Dataofproduct = new String[][]{
                    {"INTEGRALIA CONSTIFIN JARABE 250 ML", "Constifin Jarabe de Integralia está formulado a base de Eucalipto, Malva, Tomillo, Equinacea, Pino, Tolú, Drosera, Escaramujo y Própolis.", "10,7€","8"},
                    {"JARABE INFANTIL NEO PEQUES MOCOSYTOS 150 ML", "Jarabe inantil para mocos y tos.", " 7,96€","5"}
                    , {"IFISIOCREM ACTIVE 250ML", "Fisiocrem contiene una combinación especial de extractos de plantas naturales conocidas por sus efectos beneficiosos en el alivio sintomático del dolor y molestias comunes asociadas con el músculo, la articulación y el trauma de tejidos blandos.\n" +
                    "Cuando Fisiocrem se aplica a la piel con suaves masajes, la solución libera rápidamente los principios activos de la planta.", "18,15€","9"}
                    , {"THERMACARE CUELLO, HOMBRO Y MUÑECAS 6 PARCHES PARA EL DOLOR", "Aplicar del mismo modo, seguidamente cubrir el cabello con una toalla o un gorro de ducha, dejar actuar de media a una hora.", "12,50€","5"},
                    {"ARKOFLEX CONDRO AID FORTE ARKOPHARMA 120 CAPSULAS", "Arkopharma Condro Aid Forte 120 Capsulas", "18,60€","3"}
            };*/
            Phatmacy(allda,allprudect);
              //  imgs = new int[]{R.drawable.aa1, R.drawable.aa2, R.drawable.aa3, R.drawable.aa4, R.drawable.aa5};

            }


        else if (part.equals("2")){/*    Dataofproduct = new String[][]{
                {"ORAL B PRO-EXPERT DUPLO PASTA DENTRÍFRICA CON FLUOR MULTIPROTECCIÓN 125 ML+ 125 ML", "Constifin Jarabe de Integralia está formulado a base de Eucalipto, Malva, Tomillo, Equinacea, Pino, Tolú, Drosera, Escaramujo y Própolis.", "4,59€","2"},
                {"ORALKIN ENJUAGUE BUCAL ANTISÉPTICO 500 ML + 500 ML DUPLO", "Jarabe inantil para mocos y tos.", " 6,62€","8"}
                , {"MARTIDERM NIGHT RENEW 10 AMPOLLAS", "Fisiocrem contiene una combinación especial de extractos de plantas naturales conocidas por sus efectos beneficiosos en el alivio sintomático del dolor y molestias comunes asociadas con el músculo, la articulación y el trauma de tejidos blandos.\n" +
                "Cuando Fisiocrem se aplica a la piel con suaves masajes, la solución libera rápidamente los principios activos de la planta.", "16,10€","9"}
                , {"MANTECA DE KARITE TROPICANIA 150ML", "Aplicar del mismo modo, seguidamente cubrir el cabello con una toalla o un gorro de ducha, dejar actuar de media a una hora.", "5,00€","3"},
                {"PILEXIL CHAMPU ANTICAIDA 500 ML", "Arkopharma Condro Aid Forte 120 Capsulas", "11,41€","9"}
        };*/
            Phatmacy(allda,allprudect);
          // imgs = new int[]{R.drawable.aaa1, R.drawable.aaa2, R.drawable.aaa3, R.drawable.aaa4, R.drawable.aaa5};

        }



        else if (part.equals("3")){ /*   Dataofproduct = new String[][]{
                {"CHICCO TERMOMETRO DIGIBABY VARIOS COLORES", "Constifin Jarabe de Integralia está formulado a base de Eucalipto, Malva, Tomillo, Equinacea, Pino, Tolú, Drosera, Escaramujo y Própolis.", "4,95€","2"},
                {"ALMIRON ADVANCE 1 800GR", "Jarabe inantil para mocos y tos.", " 16,62€","8"}
                , {"DR BROWNS MORDEDOR SANDIA", "Fisiocrem contiene una combinación especial de extractos de plantas naturales conocidas por sus efectos beneficiosos en el alivio sintomático del dolor y molestias comunes asociadas con el músculo, la articulación y el trauma de tejidos blandos.\n" +
                "Cuando Fisiocrem se aplica a la piel con suaves masajes, la solución libera rápidamente los principios activos de la planta.", "3,90€","8"}
                , {"DODOT SENSITIVE PAÑAL RECIÉN NACIDO T2 34UDS", "Aplicar del mismo modo, seguidamente cubrir el cabello con una toalla o un gorro de ducha, dejar actuar de media a una hora.", "5,94€"},
                {"APIVITA KIDS NIÑOS CHAMPU GEL BAÑO CON MANDARINA Y MIEL RINIS 250ML", "Arkopharma Condro Aid Forte 120 Capsulas", "8,68€","5"}
        };*/

            Phatmacy(allda,allprudect);
            //imgs = new int[]{R.drawable.aaaa1, R.drawable.aaaa2, R.drawable.aaaa3, R.drawable.aaaa4, R.drawable.aaaa5};

        }
        else
        {
            /*Dataofproduct = new String[][]{
                    {"AGUA PERFUMADA ROGER GALLET GINGEMBRE ROJO 100 ML", "Constifin Jarabe de Integralia está formulado a base de Eucalipto, Malva, Tomillo, Equinacea, Pino, Tolú, Drosera, Escaramujo y Própolis.", "27,25€","9"},
                    {"NUXE COFRE PERFUME 30ML + ACEITE DE DUCHA 30ML +LECHE PERFUMADA 30ML", "Jarabe inantil para mocos y tos.", " 26,62€","5"}
                    , {"NECESER KIT DE VIAJE PRODIGIEUSE NUXE", "Fisiocrem contiene una combinación especial de extractos de plantas naturales conocidas por sus efectos beneficiosos en el alivio sintomático del dolor y molestias comunes asociadas con el músculo, la articulación y el trauma de tejidos blandos.\n" +
                    "Cuando Fisiocrem se aplica a la piel con suaves masajes, la solución libera rápidamente los principios activos de la planta.", "13,78€","2"}
                    , {"PERFUME MUJER NATURAL BETRES 100ML", "Aplicar del mismo modo, seguidamente cubrir el cabello con una toalla o un gorro de ducha, dejar actuar de media a una hora.", "8,90€","10"},
                    {"APIVITA KIDS NIÑOS CHAMPU GEL BAÑO CON MANDARINA Y MIEL RINIS 250ML", "Arkopharma Condro Aid Forte 120 Capsulas", "28,74€","5"}
            };*/
            Phatmacy(allda,allprudect);
            //jsonpart(allda,allprudect);
          //  imgs = new int[]{R.drawable.aaaaa1, R.drawable.aaaaa2, R.drawable.aaaaa3};
        }


        }





























    private void Phatmacy(String alldata,String allprudect){

    String[][] productsID={};
    int count=0;
    try {
       JSONArray jsonArray1 = new JSONArray(alldata);

         for(int i=0;i<jsonArray1.length();i++) {
            JSONObject ob = (JSONObject) jsonArray1.get(i);

          if(ob.get("pharmacyId").toString().equals(phatmacyID))
             // System.out.println("Phatmacy:"+ob.get("productId").toString()+"     "+productsID.toString());
              count++;
               }



        productsID=new String[count][1];
        int j=0;

        for(int i=0;i<jsonArray1.length();i++) {
            JSONObject ob = (JSONObject) jsonArray1.get(i);
            if(ob.get("pharmacyId").toString().equals(phatmacyID))
            {
                productsID[j][0] = ob.get("productId").toString();

                j++;
            }
        }

         JSONArray jsonArray=new JSONArray(allprudect);


        String[][] productswithdeparment=new String[j][5];
        Log.d("count id", "Phatmacy: "+j);
        j=0;
        int pos = Integer.parseInt(postion);
        pos++;
        postion=String.valueOf(pos);
        for (int i=0;i<jsonArray.length();i++)
        {

            JSONObject ob = (JSONObject) jsonArray.get(i);


            if(ob.get("productId").toString().equals(productsID[j][0])){
                JSONObject ob1=ob.getJSONObject("department");
                productswithdeparment[j][0]=ob.get("name").toString();
                productswithdeparment[j][1]=ob.get("description").toString();
                productswithdeparment[j][2]=ob.get("price").toString();
                productswithdeparment[j][3]=ob1.get("departmentId").toString();
                productswithdeparment[j][4]=ob.get("imageURL").toString();
                j++;
               // Log.d("count id", "Phatmacy:iamgessss++m  "+ob.get("imageURL").toString());

            }

        }

        j=0;



        for(int i=0;i<productswithdeparment.length;i++)
        {
            if(productswithdeparment[i][3].equals( postion))
                j++;
        }

        String productsfinal[][]=new String[j][4];
        imgs=Arrays.copyOf(imgs,j);
        j=0;

        for (int i=0;i<productswithdeparment.length;i++)
        {

            if(productswithdeparment[i][3].equals(postion))
            {

                productsfinal[j][0] = productswithdeparment[i][0];
                productsfinal[j][1] = productswithdeparment[i][1];
                productsfinal[j][2] = productswithdeparment[i][2];
                productsfinal[j][3] = String.valueOf(j*2);
                imgs[j]=productswithdeparment[i][4];
                j++;
            }

        }
        //Log.d("count id", "Phatmacy:image "+   imgs[j-1]);

        Dataofproduct=productsfinal;



    }catch (Exception ex){

    }


}
public void pay(View view){
        Intent intent=new Intent(this,Pay.class);
        startActivity(intent);


}




}
