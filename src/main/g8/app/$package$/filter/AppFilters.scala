package $package$.filter

import javax.inject.Inject

import play.api.http.DefaultHttpFilters

class AppFilters @Inject()(reqCalcFilter: RequestCalculatorFilter) extends DefaultHttpFilters(reqCalcFilter)
