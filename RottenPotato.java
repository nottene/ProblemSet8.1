public class RottenPotato {
    public static void main(String[] args) {
        int[][] ratings = {{4,6,2,5},{7,9,4,8},{6,9,3,7}};

        System.out.println("The average rating of this movie is " +movieAvgRating(ratings, 0));
        System.out.println("The average rating of this reviewer is " +reviewerAvgRating(ratings, 2));
        System.out.println("The average raint of all the movies and reviewers is " +avgRating2022(ratings));
        System.out.println("The hardest rater is rater number " +hardestRater2022(ratings));
        System.out.println("The worst movie is number " +worstMovie2022(ratings));
        System.out.println("Is the movie fresh: " +isFresh(ratings, 0));
    }

    public static double movieAvgRating(int[][] ratings, int movie) {
        double sum = 0;
        for(int i = 0; i < ratings.length; i++) {
            sum += ratings[i][movie];
            }
        return sum/ratings.length;
    }

    public static double reviewerAvgRating(int[][] ratings, int reviewer) {
        double sum = 0;
        for(int i = 0; i < ratings.length; i++) {
            if(i == reviewer) {
                for (int j = 0; j < ratings[0].length; j++) {
                    sum += ratings[i][j];
                }
            }
        }
        return sum/ratings[0].length;
    }

    public static double avgRating2022(int[][] ratings) {
        double sum = 0;
        for(int i = 0; i < ratings.length; i++) {
            for(int j = 0; j < ratings[0].length; j++) {
                sum += ratings[i][j];
            }
        }
        return sum/((ratings.length)*(ratings[0].length));
    }

    public static int hardestRater2022(int[][] ratings) {
        double worst = 0;
        double sum = 0;
        int hardestRater = 0;
        for(int i = 0; i < ratings[0].length; i++) {
            sum += ratings[0][i];
        }
        worst = sum/ratings[0].length;
        sum = 0;

        for(int i = 1; i < ratings.length; i++) {
            for(int j = 0; j < ratings[0].length; j++) {
                sum += ratings[i][j];
            }
            if(sum/ratings[0].length < worst) {
                worst = sum/ratings[0].length;
                sum = 0;
                hardestRater = i;
            } else {
                sum = 0;
            }
        }
        return hardestRater;
    }

    public static int worstMovie2022(int[][] ratings) {
        double worst = 0;
        for(int i = 0; i < ratings.length; i++) {
            worst += ratings[i][0];
        }

        double temp = 0;
        int movie = 0;
        for(int i = 1; i < ratings[0].length; i++) {
            for (int j = 0; j < ratings.length; j++) {
                temp += ratings[j][i];
            }
            if (temp < worst) {
                worst = temp;
                movie = i;
            }
            temp = 0;
        }
        return movie;
    }

    public static boolean isFresh(int[][] ratings, int movie) {
        double overallAverage = RottenPotato.avgRating2022(ratings);
        double fresh = RottenPotato.movieAvgRating(ratings, movie);

        return (fresh > overallAverage);
    }
}
