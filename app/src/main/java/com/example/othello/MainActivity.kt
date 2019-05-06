package com.example.othello

import android.graphics.Color
import android.graphics.Color.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var sqArray = arrayOfNulls<Button>(64)
    var colorArray = arrayOfNulls<Int>(64)
    val GRID_COUNT : Int = 8
    var NowPlayer : Int  = 0
    val COLOR_NON : Int = GREEN
    val COLOR_BLACK : Int = BLACK
    val COLOR_WHITE : Int = WHITE
    val VECTOR_NONE : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sqArray[0 * 8 + 0] = sq0_0
        sqArray[0 * 8 + 1] = sq0_1
        sqArray[0 * 8 + 2] = sq0_2
        sqArray[0 * 8 + 3] = sq0_3
        sqArray[0 * 8 + 4] = sq0_4
        sqArray[0 * 8 + 5] = sq0_5
        sqArray[0 * 8 + 6] = sq0_6
        sqArray[0 * 8 + 7] = sq0_7

        sqArray[1 * 8 + 0] = sq1_0
        sqArray[1 * 8 + 1] = sq1_1
        sqArray[1 * 8 + 2] = sq1_2
        sqArray[1 * 8 + 3] = sq1_3
        sqArray[1 * 8 + 4] = sq1_4
        sqArray[1 * 8 + 5] = sq1_5
        sqArray[1 * 8 + 6] = sq1_6
        sqArray[1 * 8 + 7] = sq1_7

        sqArray[2 * 8 + 0] = sq2_0
        sqArray[2 * 8 + 1] = sq2_1
        sqArray[2 * 8 + 2] = sq2_2
        sqArray[2 * 8 + 3] = sq2_3
        sqArray[2 * 8 + 4] = sq2_4
        sqArray[2 * 8 + 5] = sq2_5
        sqArray[2 * 8 + 6] = sq2_6
        sqArray[2 * 8 + 7] = sq2_7

        sqArray[3 * 8 + 0] = sq3_0
        sqArray[3 * 8 + 1] = sq3_1
        sqArray[3 * 8 + 2] = sq3_2
        sqArray[3 * 8 + 3] = sq3_3
        sqArray[3 * 8 + 4] = sq3_4
        sqArray[3 * 8 + 5] = sq3_5
        sqArray[3 * 8 + 6] = sq3_6
        sqArray[3 * 8 + 7] = sq3_7

        sqArray[4 * 8 + 0] = sq4_0
        sqArray[4 * 8 + 1] = sq4_1
        sqArray[4 * 8 + 2] = sq4_2
        sqArray[4 * 8 + 3] = sq4_3
        sqArray[4 * 8 + 4] = sq4_4
        sqArray[4 * 8 + 5] = sq4_5
        sqArray[4 * 8 + 6] = sq4_6
        sqArray[4 * 8 + 7] = sq4_7

        sqArray[5 * 8 + 0] = sq5_0
        sqArray[5 * 8 + 1] = sq5_1
        sqArray[5 * 8 + 2] = sq5_2
        sqArray[5 * 8 + 3] = sq5_3
        sqArray[5 * 8 + 4] = sq5_4
        sqArray[5 * 8 + 5] = sq5_5
        sqArray[5 * 8 + 6] = sq5_6
        sqArray[5 * 8 + 7] = sq5_7

        sqArray[6 * 8 + 0] = sq6_0
        sqArray[6 * 8 + 1] = sq6_1
        sqArray[6 * 8 + 2] = sq6_2
        sqArray[6 * 8 + 3] = sq6_3
        sqArray[6 * 8 + 4] = sq6_4
        sqArray[6 * 8 + 5] = sq6_5
        sqArray[6 * 8 + 6] = sq6_6
        sqArray[6 * 8 + 7] = sq6_7

        sqArray[7 * 8 + 0] = sq7_0
        sqArray[7 * 8 + 1] = sq7_1
        sqArray[7 * 8 + 2] = sq7_2
        sqArray[7 * 8 + 3] = sq7_3
        sqArray[7 * 8 + 4] = sq7_4
        sqArray[7 * 8 + 5] = sq7_5
        sqArray[7 * 8 + 6] = sq7_6
        sqArray[7 * 8 + 7] = sq7_7

        init()

        var loop : Int = 0
        while(loop < 64)
        {
            var row : Int= loop / 8
            var col: Int = loop % 8
            sqArray[loop]!!.setOnClickListener()
            {
                reverse(NowPlayer , row , col ,true)
                if(!searchCanReverse())
                {
                    if( NowPlayer == BLACK)
                    {
                        NowPlayer = WHITE
                        text_blackturn.text = ""
                        text_whiteturn.text = "○"
                    }else
                    {
                        NowPlayer = BLACK
                        text_blackturn.text = "○"
                        text_whiteturn.text = ""
                    }
                    if(!searchCanReverse())
                    {
                        var tx = ""
                        if (countStone(BLACK)  > countStone(WHITE))
                        {
                            tx = "Black Win"
                        }else if(countStone(BLACK)  < countStone(WHITE))
                        {
                            tx = "White Win"

                        }else
                        {
                            tx = "Draw"

                        }
                        AlertDialog.Builder(this)
                            .setTitle("Game")
                            .setMessage(tx)
                            .setPositiveButton("OK"){dialog, which ->
                                init()
                            }.show()

                    }
                }
            }
            loop++
        }



    }
    fun init()
    {
        var loop = 0
        while(loop < 64) {
            sqArray[loop]!!.setBackgroundColor(Color.GREEN)
            colorArray[loop] = COLOR_NON
            loop++
        }
        NowPlayer = BLACK
        sq3_3.setBackgroundColor(BLACK)
        sq3_4.setBackgroundColor(WHITE)
        sq4_3.setBackgroundColor(WHITE)
        sq4_4.setBackgroundColor(BLACK)
        colorArray[ 3 * GRID_COUNT + 3 ] = BLACK
        colorArray[ 3 * GRID_COUNT + 4 ] = WHITE
        colorArray[ 4 * GRID_COUNT + 3 ] = WHITE
        colorArray[ 4 * GRID_COUNT + 4 ] = BLACK
        text_blackturn.text = "○"
        text_whiteturn.text = ""
        text_blackN.text = "2"
        text_whiteN.text = "2"
    }

    fun searchCanReverse() : Boolean
    {
        var n : Int = 0
        while(n < 64)
        {
            if ( reverse( NowPlayer , n / GRID_COUNT  , n  % GRID_COUNT, false ) )
            {
                return true
            }
            n++
        }
        return false
    }

    fun reverse( stoneColor : Int , xPoint : Int , yPoint : Int , reverse : Boolean) : Boolean
    {

        if ( colorArray [ xPoint * 8 + yPoint ] != COLOR_NON )
        {
            return false
        }

        var change : Boolean = false
        colorArray[ xPoint * 8 +yPoint ] = stoneColor
        sqArray   [ xPoint * 8 +yPoint ]!!.setBackgroundColor(stoneColor)

        change = ( change or serchAndReverse( xPoint , yPoint , stoneColor , 0 , -1 , reverse))

        change = ( change or serchAndReverse( xPoint , yPoint , stoneColor , 1 , -1, reverse ))

        change = ( change or serchAndReverse( xPoint , yPoint , stoneColor , 1 , 0 , reverse ))

        change = ( change or serchAndReverse( xPoint , yPoint , stoneColor , 1, 1, reverse ))

        change = ( change or serchAndReverse( xPoint , yPoint , stoneColor , 0 , 1, reverse ))

        change = ( change or serchAndReverse( xPoint , yPoint , stoneColor , -1, 1, reverse ))

        change = ( change or serchAndReverse( xPoint , yPoint , stoneColor , -1 , 0, reverse ))

        change = ( change or serchAndReverse( xPoint , yPoint , stoneColor , -1 , -1 , reverse ))

        if ( change && reverse)
        {
            if( NowPlayer == BLACK)
            {
                NowPlayer = WHITE
                text_blackturn.text = ""
                text_whiteturn.text = "○"
            }else
            {
                NowPlayer = BLACK
                text_blackturn.text = "○"
                text_whiteturn.text = ""
            }
            text_blackN.text = countStone(BLACK).toString()
            text_whiteN.text = countStone(WHITE).toString()

        }
        else if( !change && reverse )
        {
            colorArray[ xPoint * 8 + yPoint ] = COLOR_NON
            sqArray   [ xPoint * 8 + yPoint ]!!.setBackgroundColor(COLOR_NON)
        }
        else if ( !reverse )
        {
            colorArray[ xPoint * 8 + yPoint ] = COLOR_NON
            sqArray   [ xPoint * 8 + yPoint ]!!.setBackgroundColor(COLOR_NON)
        }

        return change
    }
    fun serchAndReverse( originX : Int , originY : Int , targetColor : Int , vectorX : Int , vectorY : Int , reverse : Boolean) : Boolean
    {
        var targetX : Int = 0
        var targetY : Int = 0

        if ( originX + vectorX < 0 || originX + vectorX > 7 ||
            originY + vectorY < 0 || originY + vectorY > 7 )
        {
            return false
        }

        if ( colorArray[ (originX + vectorX) * 8 + (originY + vectorY) ] == targetColor  ||
            colorArray[ (originX + vectorX) * 8 + ( originY + vectorY )] == COLOR_NON)
        {
            return false
        }
        var i :Int = 1
        while(i < GRID_COUNT)
        {
            if ( vectorX == VECTOR_NONE )
            {
                targetX = originX
            }
            else
            {
                targetX = originX + ( i * vectorX )
            }
            if ( targetX < 0 || targetX > 7 )
            {
                return false
            }

            if ( vectorY == VECTOR_NONE )
            {
                targetY = originY
            }
            else
            {
                targetY = originY + ( i * vectorY )
            }
            if ( targetY < 0 || targetY > 7 )
            {
                return false
            }

            if ( colorArray[ targetX * GRID_COUNT + targetY ]== COLOR_NON )
            {
                return false
            }

            if ( colorArray[ targetX * GRID_COUNT + targetY ] == targetColor)
            {
                if ( reverse )
                {
                    var x : Int = originX
                    var y : Int = originY
                    while( !( targetX == x && targetY == y ) )
                    {
                        x = x + vectorX
                        y = y + vectorY
                        colorArray[ x * GRID_COUNT + y ] = targetColor
                        sqArray   [ x * GRID_COUNT + y ]!!.setBackgroundColor(targetColor)

                    }
                }
                return true
            }
        i++
        }
        return false
    }

    fun countStone( color : Int ) : Int
    {
        var cnt : Int = 0
        var i : Int = 0
        while( i < GRID_COUNT   )
        {
            var j : Int = 0
            while( j < GRID_COUNT )
            {
                if ( colorArray[ i * GRID_COUNT + j ] == color  )
                {
                    cnt++
                }
                j++
            }
            i++
        }
        return cnt
    }
}
