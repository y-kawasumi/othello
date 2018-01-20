# 詳細設計

## クラス一覧
* othello 
    * static final int UP = -1
    * static final int DOWM = 1
    * static final int LEFT = -1
    * static final int RIGHT = 1    
    * static boolean playMe
        * 現在手番
    * inner class squares
        * emun color{ black , white , blank }
        * boolean canRevers
    * squares[8][8]
        * 盤面を表現する整数型に次元配列
    * int blackN,whiteN
        * 各色の石総数
    * contractor
        * 全盤面をblankに初期化
        * 初期石を配置
    * static void revers(int xPoint , int ypoint)
        * static void revers(int xPoint , int ypoint , int xVector ,  int yVector)
            * 単一方向への石の反転処理 各8方向呼び出し
    * static void dealCanRevers()
        * static void dealCanRevers(int xVector ,  int yVector)
            * 現在手番で打石可能な場所があるかの判定
            * 手番最初に処理 可能な座標がなければパス
            * ８ｘ８のループ処理


