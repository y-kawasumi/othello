package 010_OTHELLO ;

public class othello {
    
    /* typedef */
    common con = new common();

    /* Search Vector */
    static final int UP         = -1 ;
    static final int DOWN       = 1 ;
    static final int LEFT       = -1 ;
    static final int RIGHT      = 1 ;
    static final int NEUTRAL    = 0 ;

    /* stone count */
    static int blackN ;
    static int whiteN ;

    static boolean turnWhite ;

    class squares {
        enum coloer {
            black ,
            white ,
            blank
        } ;
        boolean canRevers ;
    } 

    squares[con.X_MAX][con.Y_MAX] table ;

     /* 盤面情報の初期化処理
      * 各マスのクリアと初期石配置
      * commonクラスの定数を書き換えることによって８ｘ８以外の盤面も実装可能
      */
    public othello ( void ) {
        
        for( int xPos = 0 ; xPos < con.X_MAX ; xPos++ ) {

            for( int yPos = 0 ; yPos < con.Y_MAX ; yPos++ ) {
                table[xPos][yPos].canRevers = false ;
                table[xPos][yPos].coloer  = coloer.blank ;
            }

        }

        table[xPos/2]  [yPos/2].coloer      = coloer.white ;
        table[xPos/2+1][yPos/2+1].coloer    = coloer.white ;
        table[xPos/2]  [yPos/2+1].coloer    = coloer.black ;
        table[xPos/2+1][yPos/2].coloer      = coloer.black ;
    }

    /* API 反転処理API
     * @param int xPoint X座標起点
     * @param int yPoint Y座標起点
     */
    static void revers( int xPoint , int yPoint ){
        /* ８方向への探査 */
        revers( xPoint , yPoint , UP , NEUTRAL ) ;
        revers( xPoint , yPoint , DOWN , NEUTRAL ) ;
        revers( xPoint , yPoint , NEUTRAL , LEFT ) ;
        revers( xPoint , yPoint , NEUTRAL , RIGHT ) ;
        revers( xPoint , yPoint , UP , LEFT ) ;
        revers( xPoint , yPoint , UP , RIGHT ) ;
        revers( xPoint , yPoint , DOWN , LEFT ) ;
        revers( xPoint , yPoint , DOWN , RIGHT ) ;        
    }

    /* 一方向への反転処理
     * @param int xPoint X座標起点
     * @param int yPoint Y座標起点
     * @param int xVector X探査方向
     * @param int yVector Y探査方向
     */
    static void revers( int xPoint , int ypoint , int xVector ,  int yVector ){

    }
    
    /* API 手番切り替わり時の打石可能マスの検査
     */
    static void dealCanRevers(){
        
        for( int xPoint = 0 ; xPoint < common.X_MAX ; xPoint++ ){

            for( itn yPoint = 0 ; yPoint < Y_MAX ; yPoint++ ){
            
                dealCanRevers( xPoint , yPoint , UP, NEUTRAL ) ;
                dealCanRevers( xPoint , yPoint , DOWN, NEUTRAL ) ;
                dealCanRevers( xPoint , yPoint , NEUTRAL, RIGHT ) ;
                dealCanRevers( xPoint , yPoint , NEUTRAL, LEFT ) ;
                dealCanRevers( xPoint , yPoint , UP, RIGHT ) ;
                dealCanRevers( xPoint , yPoint , UP, LEFT ) ;
                dealCanRevers( xPoint , yPoint , DOWN, RIGHT ) ;
                dealCanRevers( xPoint , yPoint , DOWN, LEFT ) ;
                
            }
        }
    }

    /* 手番切り替わり時の打石可能マスの検査 
     * 一方向への検査
     * @param int xPoint X座標起点
     * @param int yPoint Y座標起点
     * @param int xVector X探査方向
     * @param int yVector Y探査方向
     */
    static void dealCanRevers( int xPoint , int yPoint , int xVector ,  int yVector ){

    }
}