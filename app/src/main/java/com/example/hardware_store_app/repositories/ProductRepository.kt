package com.example.hardware_store_app.repositories

import com.example.hardware_store_app.R
import com.example.hardware_store_app.data.Product
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ProductRepository @Inject constructor() {
    fun getList(): List<Product> {
        return listOf(
            Product(
                1,
                "Yellow brick",
                R.drawable.brick_1,
                1500.0,
                "Building Materials",
                "Hyperpressed brick is an innovative building material created by hydromechanically pressing a mixture of cement, sand, lime and special additives. It has exceptional strength and resistance to external influences, which makes it an ideal choice for construction.",
                2.0
            ),
            Product(
                2,
                "Red brick",
                R.drawable.brick_2,
                1500.0,
                "Building Materials",
                "Hyperpressed brick is an innovative building material created by hydromechanically pressing a mixture of cement, sand, lime and special additives. It has exceptional strength and resistance to external influences, which makes it an ideal choice for construction.",
                2.5
            ),
            Product(
                3,
                "Black brick",
                R.drawable.brick_3,
                1700.0,
                "Building Materials",
                "Hyperpressed brick is an innovative building material created by hydromechanically pressing a mixture of cement, sand, lime and special additives. It has exceptional strength and resistance to external influences, which makes it an ideal choice for construction.",
                4.9
            ),
            Product(
                4,
                "Brown brick",
                R.drawable.brick_4,
                1500.0,
                "Building Materials",
                "Hyperpressed brick is an innovative building material created by hydromechanically pressing a mixture of cement, sand, lime and special additives. It has exceptional strength and resistance to external influences, which makes it an ideal choice for construction.",
                4.8
            ),
            Product(
                5,
                "Gray brick",
                R.drawable.brick_5,
                1500.0,
                "Building Materials",
                "Hyperpressed brick is an innovative building material created by hydromechanically pressing a mixture of cement, sand, lime and special additives. It has exceptional strength and resistance to external influences, which makes it an ideal choice for construction.",
                3.8
            ),
            Product(
                6,
                "Marble brick",
                R.drawable.brick_6,
                2500.0,
                "Building Materials",
                "Marble brick is an innovative building material created by hydromechanically pressing a mixture of cement, sand, lime and special additives. It has exceptional strength and resistance to external influences, which makes it an ideal choice for construction.",
                5.0
            ),
            Product(
                7,
                "Aerated-concrete block",
                R.drawable.brick_7,
                3800.0,
                "Building Materials",
                "300/200/600 Aerated-concrete block is an innovative building material created by hydromechanically pressing a mixture of cement, sand, lime and special additives. It has exceptional strength and resistance to external influences, which makes it an ideal choice for construction.",
                5.0
            ),
            Product(
                8,
                "Linden tree beam",
                R.drawable.brick_8,
                2000.0,
                "Building Materials",
                "Wood beam is a reliable and versatile building material made from high quality wood. It has strength, resistance to external influences and durability.",
                4.5
            ),
            Product(
                9,
                "Pine timber",
                R.drawable.brick_9,
                4320.0,
                "Building Materials",
                "Pine timber is a reliable and versatile building material made from high quality wood. It has strength, resistance to external influences and durability.",
                2.1
            ),
            Product(
                10,
                "Plate OSB-3",
                R.drawable.brick_10,
                5000.0,
                "Building Materials",
                "Plate OSB-3 is a reliable and versatile building material made from high quality wood. It has strength, resistance to external influences and durability.",
                4.9
            ),
            Product(
                11,
                "Farbex graphite paint",
                R.drawable.paint_1,
                239.9,
                "Paints & Varnishes",
                "Universal rubber paint Farbex 1.2kg Graphite",
                4.9
            ),
            Product(
                12,
                "Farbex graphite paint",
                R.drawable.paint_2,
                130.0,
                "Paints & Varnishes",
                "Interior acrylic wash paint TRIORA 1.4kg White",
                4.7
            ),
            Product(
                13,
                "Maxima acrylic impregnate",
                R.drawable.paint_3,
                270.0,
                "Paints & Varnishes",
                "Acrylic impregnate Maxima deep penetration 0.75l Colorless",
                4.5
            ),
            Product(
                14,
                "TRIORA interior varnish",
                R.drawable.paint_4,
                240.0,
                "Paints & Varnishes",
                "Interior varnish TRIORA semi-matte 0.75l Colorless",
                4.9
            ),
            Product(
                15,
                "Maxima wood protection",
                R.drawable.paint_5,
                700.0,
                "Paints & Varnishes",
                "Wood protection agent Maxima 2.5l Autumn maple",
                4.9
            ),
            Product(
                16,
                "Feidal decorative plaster",
                R.drawable.paint_6,
                2015.0,
                "Paints & Varnishes",
                "Decorative plaster Feidal Marmorinputz mini type Marmorino 10kg",
                4.6
            ),
            Product(
                17,
                "Maxima decorative coating",
                R.drawable.paint_7,
                3721.0,
                "Paints & Varnishes",
                "Maxima decorative coating with marble effect \"Stucco Veneziano\" 15 kg",
                4.8
            ),
            Product(
                18,
                "TRIORA fire bioprotection",
                R.drawable.paint_8,
                218.53,
                "Paints & Varnishes",
                "Fire bioprotection for wood TRIORA No. 2.5l",
                4.8
            ),
            Product(
                18,
                "Farbex antiseptic",
                R.drawable.paint_8,
                218.53,
                "Paints & Varnishes",
                "Farbex antiseptic for wooden surfaces 2l",
                4.8
            ),
            Product(
                19,
                "Farbex antiseptic",
                R.drawable.paint_9,
                120.23,
                "Paints & Varnishes",
                "Farbex antiseptic for wooden surfaces 2l",
                4.8
            ),
            Product(
                20,
                "Zebra Solvent",
                R.drawable.paint_10,
                120.23,
                "Paints & Varnishes",
                "Solvent Zebra White spirit 0.5l",
                4.8
            ),
            Product(
                21,
                "Schneider Electric socket",
                R.drawable.electric_1,
                200.00,
                "Electrical Goods",
                "Computer socket Schneider Electric Asfora RJ45 category 5 UTP White with a frame",
                4.9
            ),
            Product(
                22,
                "VIDEX socket",
                R.drawable.electric_2,
                550.00,
                "Electrical Goods",
                "VIDEX Binera socket with grounding and two USB White",
                3.2
            ),
            Product(
                23,
                "Schneider circuit breaker",
                R.drawable.electric_3,
                100.00,
                "Electrical Goods",
                "1-key switch Schneider Electric Asfora 10A Cream with frame",
                3.2
            ),
            Product(
                24,
                "Schneider circuit breaker",
                R.drawable.electric_4,
                100.00,
                "Electrical Goods",
                "2-key switch Schneider Electric Asfora 10A White with frame",
                4.1
            ),
            Product(
                25,
                "Schneider Electric socket",
                R.drawable.electric_5,
                120.00,
                "Electrical Goods",
                "Schneider Electric Asfora grounding socket White with frame",
                5.0
            ),
            Product(
                26,
                "Schneider Electric socket",
                R.drawable.electric_6,
                160.00,
                "Electrical Goods",
                "Double outlet with grounding Schneider Electric Asfora Kremov",
                4.9
            ),
            Product(
                27,
                "Screw Metalvis",
                R.drawable.bolt_1,
                69.90,
                "Fasteners",
                "Screw Metalvis 401C 3.5x45 mm for plasterboard on wood PH2 100 pcs",
                5.0
            ),
            Product(
                28,
                "Screw Metalvis",
                R.drawable.bolt_1,
                179.90,
                "Fasteners",
                "Screw Metalvis 401C 3.5x45 mm for plasterboard on wood PH2 300 pcs",
                5.0
            ),
            Product(
                28,
                "Screw Metalvis",
                R.drawable.bolt_1,
                289.90,
                "Fasteners",
                "Screw Metalvis 401C 3.5x45 mm for plasterboard on wood PH2 600 pcs",
                5.0
            ),
            Product(
                29,
                "Cable tie",
                R.drawable.bolt_2,
                99.0,
                "Fasteners",
                "Cable tie, plastic clamp - 2.5 * 150 Black",
                5.0
            ),
            Product(
                30,
                "Cable tie",
                R.drawable.bolt_2,
                270.0,
                "Fasteners",
                "Cable tie, plastic clamp - 2.5 * 150 Black",
                5.0
            ),
            Product(
                31,
                "Stapler nail Intertool",
                R.drawable.bolt_3,
                250.0,
                "Fasteners",
                "Stapler nail Intertool PT-1603 30 mm (1x1.25 mm) 5000 pcs",
                4.7
            ),
            Product(
                32,
                "Stapler nail Intertool",
                R.drawable.bolt_4,
                790.90,
                "Fasteners",
                "Smooth nails in a drum Makita F-31317 (3.1x90 mm, 4000 pcs) for pneumatic nail guns",
                4.3
            ),
            Product(
                33,
                "Epoxy resin",
                R.drawable.chem_1,
                560.75,
                "Chemistry",
                "Epoxy resin is transparent 1l",
                4.8
            ),
            Product(
                34,
                "Polyurethane glue 1K",
                R.drawable.chem_2,
                11560.0,
                "Chemistry",
                "Polyurethane glue 1K for membrane-vacuum pressing Unicol Nunipur 7031 (20l)",
                2.1
            ),
            Product(
                35,
                "Concentrate Barracuda",
                R.drawable.chem_3,
                1520.0,
                "Chemistry",
                "BARRACUDA CS. CPC CONCENTRATE. Means for removing cement, concrete, salts, construction mortars, lime scale (5 l)",
                4.8
            ),
            Product(
                36,
                "Express cement Ceresit",
                R.drawable.mix_1,
                350.0,
                "Chemistry",
                "Express cement Ceresit CX 5 quick anchoring (5kg)",
                4.9
            ),
            Product(
                37,
                "Cement Eurostandard",
                R.drawable.mix_2,
                200.0,
                "Chemistry",
                "Cement Eurostandard M500 (25kg)",
                4.9
            ),
            Product(
                38,
                "Self-leveling mixture",
                R.drawable.mix_3,
                315.0,
                "Chemistry",
                "Self-leveling mixture Budmonster BM 5.2, 2-20 mm, (25kg)",
                5.0
            ),
            Product(
                39,
                "Universal mixture",
                R.drawable.mix_4,
                100.0,
                "Chemistry",
                "Universal mix BudMonster cement-sand BM 6.0, (25kg)",
                4.6
            ),
            Product(
                40,
                "Reinforcement mixture",
                R.drawable.mix_5,
                280.0,
                "Chemistry",
                "Adhesive reinforcement mixture Alpina EXPERT Klebe-Armierungsmörtel, (25kg)",
                4.8
            )
        )
    }
}